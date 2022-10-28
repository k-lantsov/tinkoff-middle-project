package com.company.personservice.controller.v1.dto.person;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class V1PersonSaveRequestModel {

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    private Set<UUID> documentUUIDs;

    private Set<UUID> addressUUIDs;

    private Set<UUID> contactUUIDs;
}
