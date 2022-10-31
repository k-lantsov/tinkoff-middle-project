package com.company.personservice.controller.v1.converter;

import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.service.dto.person.PersonDtoRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1PersonControllerConverter {

    private final ModelMapper mapper;

    public PersonDtoRequest convertV1PersonRequestModelToPersonSaveDto(V1PersonRequestModel requestModel) {
        return mapper.map(requestModel, PersonDtoRequest.class);
    }
}
