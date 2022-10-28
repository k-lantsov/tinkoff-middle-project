package com.company.personservice.controller.v1.dto.contact;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class V1ContactRequestModel {

    private String contactType;

    private String contactValue;
}
