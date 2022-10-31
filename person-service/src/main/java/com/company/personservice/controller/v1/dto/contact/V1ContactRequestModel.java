package com.company.personservice.controller.v1.dto.contact;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class V1ContactRequestModel {

    @NotBlank
    private String contactType;

    @NotBlank
    private String contactValue;
}
