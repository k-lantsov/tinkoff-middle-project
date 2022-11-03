package com.company.personservice.service.dto.person;

import com.company.personservice.service.dto.address.AddressDto;
import com.company.personservice.service.dto.contact.ContactDto;
import com.company.personservice.service.dto.document.IdentityDocumentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class PersonWithDetailsResponseDto {

    private UUID uuid;

    private String firstname;

    private String lastname;

    private Set<IdentityDocumentDto> documents;

    private Set<AddressDto> addresses;

    private Set<ContactDto> contacts;

}
