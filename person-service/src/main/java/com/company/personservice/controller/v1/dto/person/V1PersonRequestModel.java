package com.company.personservice.controller.v1.dto.person;

import com.company.personservice.controller.v1.dto.address.V1AddressRequestModel;
import com.company.personservice.controller.v1.dto.contact.V1ContactRequestModel;
import com.company.personservice.controller.v1.dto.document.V1IdentityDocumentRequestModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class V1PersonRequestModel {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    private Set<V1IdentityDocumentRequestModel> documents;

    private Set<V1AddressRequestModel> addresses;

    private Set<V1ContactRequestModel> contacts;
}
