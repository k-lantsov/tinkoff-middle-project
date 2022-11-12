package com.company.personservice.repository;

import com.company.personservice.entity.IdentityDocument;
import com.company.personservice.entity.Person;
import com.company.personservice.entity.enums.DocumentType;
import com.company.personservice.exception.PersonNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PersonRepository repository;
    private Person person;

    @BeforeEach
    void prepare() {
        person = Person.builder()
                .firstname("Leon")
                .lastname("Lantsov")
                .build();
        IdentityDocument document = new IdentityDocument();
        document.setDocumentType(DocumentType.PASSPORT);
        document.setDocumentNumber("MP21082022");
        document.setPerson(person);
        person.setDocuments(Set.of(document));
    }

    @Test
    void testSave_whenGivenPerson_thenReturnPerson() {
        // act
        Person storedPerson = entityManager.persistAndFlush(person);

        //assert
        assertAll(
                () -> assertThat(storedPerson.getId()).isNotZero(),
                () -> assertThat(storedPerson.getUuid()).isEqualTo(person.getUuid())
        );
    }

    @Test
    void testFindByPersonLastname_whenGivenPersonStoredInDb_thenReturnPerson() {
        // arrange
        entityManager.persistAndFlush(person);

        // act
        Person storedPerson = repository.findByPersonLastname(person.getLastname()).orElseThrow();

        // assert
        assertThat(storedPerson.getLastname()).isEqualTo(person.getLastname());
    }

    @Test
    void testFindByPersonLastname_whenGivenPersonNotStoredInDb_thenThrowException() {
        // act & assert
        assertThrows(PersonNotFoundException.class,
                () -> repository.findByPersonLastname(person.getLastname())
                .orElseThrow(() -> new PersonNotFoundException("There is no person in db")),
                "It was expecting a PersonNotFoundException to be thrown");
    }
}