package com.company.personservice.service;

import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonResponseDto;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    void savePerson(PersonRequestDto person);
    PersonResponseDto findByUuid(UUID uuid);
    List<PersonResponseDto> findAll();
}
