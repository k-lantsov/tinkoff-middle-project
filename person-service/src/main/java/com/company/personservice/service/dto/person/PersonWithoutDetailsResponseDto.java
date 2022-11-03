package com.company.personservice.service.dto.person;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonWithoutDetailsResponseDto {

    private UUID uuid;

    private String firstname;

    private String lastname;
}
