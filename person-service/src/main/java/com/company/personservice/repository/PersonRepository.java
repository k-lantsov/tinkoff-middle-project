package com.company.personservice.repository;

import com.company.personservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("""
            select p from Person p
            join fetch p.addresses addresses
            join fetch p.documents documents
            join fetch p.contacts contacts
            where p.uuid = :uuid
            """)
    Optional<Person> findByUuid(UUID uuid);

    @Query("select p from Person p join fetch p.documents")
    Optional<Person> findByPersonLastname(String lastname);
}
