package com.company.personservice.controller.v1.dto.person;

import com.company.personservice.controller.v1.dto.address.V1AddressResponseModel;
import com.company.personservice.controller.v1.dto.contact.V1ContactResponseModel;
import com.company.personservice.controller.v1.dto.document.V1IdentityDocumentResponseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class V1PersonResponseModel {

    private UUID uuid;

    private String firstname;

    private String lastname;

    private Set<V1IdentityDocumentResponseModel> documents;

    private Set<V1AddressResponseModel> addresses;

    private Set<V1ContactResponseModel> contacts;
}
