package com.company.personservice.controller.v1.converter;

import com.company.personservice.controller.v1.dto.person.V1PersonSaveRequestModel;
import com.company.personservice.service.dto.person.PersonSaveDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1PersonConverter {

    private final ModelMapper mapper;

    public PersonSaveDto convertV1PersonSaveRequestModelToPersonSaveDto(V1PersonSaveRequestModel requestModel) {
        return mapper.map(requestModel, PersonSaveDto.class);
    }
}
