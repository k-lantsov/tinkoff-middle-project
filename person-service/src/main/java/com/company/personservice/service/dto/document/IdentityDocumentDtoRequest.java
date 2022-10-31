package com.company.personservice.service.dto.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdentityDocumentDtoRequest {

    private String documentNumber;

    private String documentType;
}
