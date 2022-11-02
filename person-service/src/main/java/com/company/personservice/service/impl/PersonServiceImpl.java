package com.company.personservice.service.impl;

import com.company.personservice.entity.Person;
import com.company.personservice.repository.PersonRepository;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.converter.PersonServiceConverter;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonResponseDto;
import com.company.personservice.util.PersonMessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public PersonResponseDto findByUuid(UUID uuid) {
        Person personFromDB = repository.findByUuid(uuid).orElseThrow();
        return converter.convertPersonToPersonResponseDto(personFromDB);
    }

    @Override
    public List<PersonResponseDto> findAll() {
        List<Person> personsFromDB = repository.findAll();
        for (Person person: personsFromDB) {
            person.setDocuments(null);
            person.setAddresses(null);
            person.setContacts(null);
        }
        return personsFromDB.stream().map(converter::convertPersonToPersonResponseDto).collect(Collectors.toList());
    }
}
