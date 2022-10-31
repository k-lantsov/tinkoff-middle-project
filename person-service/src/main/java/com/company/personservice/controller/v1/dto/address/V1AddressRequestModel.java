package com.company.personservice.controller.v1.dto.address;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class V1AddressRequestModel {

    @NotBlank
    private String country;

    @NotBlank
    private String locality;

    @NotBlank
    private String street;

    @NotNull
    private int houseNumber;

    @NotNull
    private int apartmentsNumber;

    @NotBlank
    private String postcode;

    @NotBlank
    private String addressType;
}
