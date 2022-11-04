package com.company.personservice.service;

import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonWithDetailsResponseDto;
import com.company.personservice.service.dto.person.PersonWithoutDetailsResponseDto;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    void savePerson(PersonRequestDto person);
    PersonWithDetailsResponseDto findByUuid(UUID uuid);
    List<PersonWithoutDetailsResponseDto> findAll();
    boolean findByPersonLastname(String lastname, String documentType, String documentNumber);
}
