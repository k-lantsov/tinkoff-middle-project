package com.company.personservice.controller.v1.converter;

import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.controller.v1.dto.person.V1PersonResponseModel;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1PersonControllerConverter {

    private final ModelMapper mapper;

    public PersonRequestDto convertV1PersonRequestModelToPersonRequestDto(V1PersonRequestModel requestModel) {
        return mapper.map(requestModel, PersonRequestDto.class);
    }

    public V1PersonResponseModel convertPersonResponseDtoToV1PersonResponseModel(PersonResponseDto personResponseDto) {
        return mapper.map(personResponseDto, V1PersonResponseModel.class);
    }
}
