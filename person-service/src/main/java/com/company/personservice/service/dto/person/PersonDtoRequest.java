package com.company.personservice.service.dto.person;

import com.company.personservice.service.dto.address.AddressDtoRequest;
import com.company.personservice.service.dto.contact.ContactDtoRequest;
import com.company.personservice.service.dto.document.IdentityDocumentDtoRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonDtoRequest {

    private String firstname;

    private String lastname;

    private Set<IdentityDocumentDtoRequest> documents;

    private Set<AddressDtoRequest> addresses;

    private Set<ContactDtoRequest> contacts;

}
