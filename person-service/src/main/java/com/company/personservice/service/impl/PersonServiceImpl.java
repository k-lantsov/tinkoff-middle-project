package com.company.personservice.service.impl;

import com.company.personservice.entity.Person;
import com.company.personservice.exception.PersonNotFoundException;
import com.company.personservice.repository.PersonRepository;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.converter.PersonServiceConverter;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonWithDetailsResponseDto;
import com.company.personservice.service.dto.person.PersonWithoutDetailsResponseDto;
import com.company.personservice.util.PersonMessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final PersonServiceConverter converter;

    @Transactional
    @Override
    public void savePerson(PersonRequestDto personRequestDto) {
        Person beforeSavePerson = converter.convertPersonRequestDtoToPerson(personRequestDto);
        log.info(PersonMessageUtil.onSavePerson(beforeSavePerson));
        beforeSavePerson.getContacts().forEach(contact -> contact.setPerson(beforeSavePerson));
        beforeSavePerson.getDocuments().forEach(document -> document.setPerson(beforeSavePerson));
        Person savedPerson = repository.save(beforeSavePerson);
        log.info(PersonMessageUtil.onSavePersonSuccess(savedPerson));
    }

    @Transactional
    @Override
    public PersonWithDetailsResponseDto findByUuid(UUID uuid) {
        log.info(PersonMessageUtil.onGetPersonByUuid(uuid));
        Person personFromDB = repository.findByUuid(uuid)
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person with uuid = %s not found", uuid)));
        PersonWithDetailsResponseDto personWithDetailsResponseDto = converter.convertPersonToPersonWithDetailsResponseDto(personFromDB);
        log.info(PersonMessageUtil.onGetPersonByUuidSuccess());
        return personWithDetailsResponseDto;
    }

    @Override
    public List<PersonWithoutDetailsResponseDto> findAll() {
        log.info(PersonMessageUtil.onGetAllPersonsWithoutDetails());
        List<PersonWithoutDetailsResponseDto> personWithoutDetailsResponseDtos = repository.findAll().stream()
                .map(converter::convertPersonToPersonWithoutDetailsResponseDto)
                .toList();
        log.info(PersonMessageUtil.onGetAllPersonsWithoutDetailsSuccess());
        return personWithoutDetailsResponseDtos;
    }

    @Override
    public boolean findByPersonLastname(String lastname, String documentType, String documentNumber) {
        log.info(PersonMessageUtil.onGetPersonByLastname(lastname));
        Person personFromDB = repository.findByPersonLastname(lastname)
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person with lastname = %s not found", lastname)));
        log.info(PersonMessageUtil.onGetPersonByLastnameSuccess());
        return personFromDB.getDocuments().stream()
                .anyMatch(document ->
                        document.getDocumentType().name().equalsIgnoreCase(documentType) &&
                                document.getDocumentNumber().equalsIgnoreCase(documentNumber));
    }
}
