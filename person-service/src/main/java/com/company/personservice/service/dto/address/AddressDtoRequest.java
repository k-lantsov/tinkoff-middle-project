package com.company.personservice.service.dto.address;

import lombok.Data;

@Data
public class AddressDtoRequest {

    private String country;

    private String locality;

    private String street;

    private int houseNumber;

    private int apartmentsNumber;

    private String postcode;

    private String addressType;
}
