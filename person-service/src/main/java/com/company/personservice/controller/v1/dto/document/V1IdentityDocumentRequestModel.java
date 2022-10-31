package com.company.personservice.controller.v1.dto.document;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class V1IdentityDocumentRequestModel {

    @NotBlank
    private String documentNumber;

    @NotBlank
    private String documentType;
}
