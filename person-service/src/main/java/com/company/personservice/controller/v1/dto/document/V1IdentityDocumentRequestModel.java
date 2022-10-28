package com.company.personservice.controller.v1.dto.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class V1IdentityDocumentRequestModel {

    private String documentNumber;
    private String documentType;
}
