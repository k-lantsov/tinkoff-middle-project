package com.company.personservice.controller.v1;

import com.company.personservice.controller.v1.converter.V1PersonControllerConverter;
import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.controller.v1.dto.person.V1PersonResponseModel;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.dto.person.PersonResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/persons")
public class V1PersonController {

    private final PersonService personService;

    private final V1PersonControllerConverter converter;

    @Operation(summary = "Save new person", tags = {"v1-person-controller"})
    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody @Valid V1PersonRequestModel requestModel) {
        personService.savePerson(converter.convertV1PersonRequestModelToPersonRequestDto(requestModel));
        return ResponseEntity.status(HttpStatus.CREATED).body("Person was saved");
    }

    @Operation(summary = "Get person information", tags = {"v1-person-controller"})
    @GetMapping(value = "/{uuid}")
    public ResponseEntity<V1PersonResponseModel> getPersonInfo(@PathVariable UUID uuid) {
        PersonResponseDto personResponseDto = personService.findByUuid(uuid);
        V1PersonResponseModel responseModel = converter.convertPersonResponseDtoToV1PersonResponseModel(personResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @Operation(summary = "Get information about all persons", tags = {"v1-person-controller"})
    @GetMapping
    public ResponseEntity<List<V1PersonResponseModel>> getPersonInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll().stream()
                .map(converter::convertPersonResponseDtoToV1PersonResponseModel)
                .collect(Collectors.toList()));
    }
}
