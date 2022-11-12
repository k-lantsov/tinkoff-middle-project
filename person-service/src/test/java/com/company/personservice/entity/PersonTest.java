package com.company.personservice.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class PersonTest {

    @Autowired
    private TestEntityManager entityManager;

    private Person person;

    @BeforeEach
    void prepare() {
        person = Person.builder()
                .firstname("Leon")
                .lastname("Lantsov")
                .build();
    }

    @Test
    void testPerson_whenValidPersonDetailsProvided_thenReturnStoredPersonDetails() {
        // act
        Person storedPerson = entityManager.persistAndFlush(person);

        // assert
        assertAll(
                () -> assertThat(storedPerson.getId()).isNotZero(),
                () -> assertThat(storedPerson.getUuid()).isEqualTo(person.getUuid())
        );
    }

    @Test
    void testPerson_whenInvalidPersonDetailsProvided_thenThrowException() {
        // arrange
        person.setFirstname(null);

        // act & assert
        assertThrows(PersistenceException.class,
                () -> entityManager.persistAndFlush(person),
                "It was expecting a PersistenceException to be thrown");
    }

    @Test
    void testPerson_whenExistingPersonUuidProvided_thenThrowException() {
        // arrange
        entityManager.persistAndFlush(person);
        Person newPerson = Person.builder()
                .firstname("test")
                .lastname("test")
                .build();
        newPerson.setUuid(person.getUuid());

        // act & assert
        assertThrows(PersistenceException.class,
                () -> entityManager.persistAndFlush(newPerson),
                "It was expecting a PersistenceException to be thrown");
    }
}