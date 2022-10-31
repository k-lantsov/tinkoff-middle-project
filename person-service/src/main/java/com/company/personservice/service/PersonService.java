package com.company.personservice.service;

import com.company.personservice.service.dto.person.PersonDtoRequest;

public interface PersonService {
    void savePerson(PersonDtoRequest person);
}
