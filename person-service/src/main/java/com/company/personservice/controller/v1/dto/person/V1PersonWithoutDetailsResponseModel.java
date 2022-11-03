package com.company.personservice.controller.v1.dto.person;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class V1PersonWithoutDetailsResponseModel {

    private UUID uuid;

    private String firstname;

    private String lastname;
}
