package com.company.personservice.service.impl;

import com.company.personservice.entity.Person;
import com.company.personservice.repository.PersonRepository;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.converter.PersonServiceConverter;
import com.company.personservice.service.dto.person.PersonDtoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final PersonServiceConverter converter;

    @Transactional
    @Override
    public void savePerson(PersonDtoRequest personDtoRequest) {
        Person beforeSavePerson = converter.convertPersonDtoRequestToPerson(personDtoRequest);
        beforeSavePerson.getContacts().forEach(contact -> contact.setPerson(beforeSavePerson));
        beforeSavePerson.getDocuments().forEach(document -> document.setPerson(beforeSavePerson));
        repository.save(beforeSavePerson);
    }
}
