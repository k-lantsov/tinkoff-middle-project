package com.company.personservice.controller.v1.dto.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class V1AddressRequestModel {

    private String country;

    private String locality;

    private String street;

    private int houseNumber;

    private int apartmentsNumber;

    private String postcode;

    private String addressType;
}
