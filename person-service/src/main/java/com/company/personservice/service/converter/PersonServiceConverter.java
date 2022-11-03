package com.company.personservice.service.converter;

import com.company.personservice.entity.Person;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonWithDetailsResponseDto;
import com.company.personservice.service.dto.person.PersonWithoutDetailsResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonServiceConverter {

    private final ModelMapper mapper;

    public Person convertPersonRequestDtoToPerson(PersonRequestDto personRequestDto) {
        return mapper.map(personRequestDto, Person.class);
    }
    public PersonWithDetailsResponseDto convertPersonToPersonWithDetailsResponseDto(Person person) {
        return mapper.map(person, PersonWithDetailsResponseDto.class);
    }

    public PersonWithoutDetailsResponseDto convertPersonToPersonWithoutDetailsResponseDto(Person person) {
        return mapper.map(person, PersonWithoutDetailsResponseDto.class);
    }
}
