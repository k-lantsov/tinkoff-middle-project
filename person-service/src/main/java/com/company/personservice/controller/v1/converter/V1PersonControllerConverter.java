package com.company.personservice.controller.v1.converter;

import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.controller.v1.dto.person.V1PersonWithDetailsResponseModel;
import com.company.personservice.controller.v1.dto.person.V1PersonWithoutDetailsResponseModel;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.company.personservice.service.dto.person.PersonWithDetailsResponseDto;
import com.company.personservice.service.dto.person.PersonWithoutDetailsResponseDto;
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

    public V1PersonWithDetailsResponseModel convertPersonWithDetailsResponseDtoToV1PersonResponseModel(PersonWithDetailsResponseDto personWithDetailsResponseDto) {
        return mapper.map(personWithDetailsResponseDto, V1PersonWithDetailsResponseModel.class);
    }

    public V1PersonWithoutDetailsResponseModel convertPersonWithoutDetailsResponseDtoToV1PersonWithoutDetailsResponseModel(PersonWithoutDetailsResponseDto personWithoutDetailsResponseDto) {
        return mapper.map(personWithoutDetailsResponseDto, V1PersonWithoutDetailsResponseModel.class);
    }
}
