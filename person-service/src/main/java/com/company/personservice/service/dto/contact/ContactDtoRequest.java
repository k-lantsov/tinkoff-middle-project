package com.company.personservice.service.dto.contact;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContactDtoRequest {

    private String contactType;

    private String contactValue;
}
