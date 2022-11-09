package com.company.personservice.service.impl;

import com.company.personservice.entity.Person;
import com.company.personservice.repository.PersonRepository;
import com.company.personservice.service.converter.PersonServiceConverter;
import com.company.personservice.service.dto.person.PersonRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl service;
    @Mock
    private PersonRepository repository;
    @Mock
    private PersonServiceConverter converter;
    private Person person;

    @BeforeEach
    void init() {
        System.out.println("Before each");
        person = Person.builder()
                .firstname("Konstantin")
                .lastname("Lantsov")
                .documents(Collections.emptySet())
                .addresses(Collections.emptySet())
                .contacts(Collections.emptySet())
                .build();
        person.setId(1L);
    }

    @Test
    void testSavePerson_whenPersonDetailsProvided() {
        doReturn(person).when(repository).save(any(Person.class));
        doReturn(person).when(converter).convertPersonRequestDtoToPerson(any(PersonRequestDto.class));

        PersonRequestDto personRequestDto = new PersonRequestDto();
        personRequestDto.setFirstname(person.getFirstname());
        personRequestDto.setLastname(person.getLastname());
        service.savePerson(personRequestDto);

        verify(repository).save(person);
    }

}