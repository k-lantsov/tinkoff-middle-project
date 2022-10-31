package com.company.personservice.service.converter;

import com.company.personservice.entity.Person;
import com.company.personservice.service.dto.person.PersonDtoRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonServiceConverter {

    private final ModelMapper mapper;

    public Person convertPersonDtoRequestToPerson(PersonDtoRequest personDtoRequest) {
        return mapper.map(personDtoRequest, Person.class);
    }
}
