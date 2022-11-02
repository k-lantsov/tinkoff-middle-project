package com.company.personservice.controller.v1.dto.address;

import lombok.Data;

@Data
public class V1AddressResponseModel {

    private String country;

    private String locality;

    private String street;

    private int houseNumber;

    private int apartmentsNumber;

    private String postcode;

    private String addressType;
}
