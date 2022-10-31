package com.company.personservice.controller.v1;

import com.company.personservice.controller.v1.converter.V1PersonControllerConverter;
import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.dto.person.PersonDtoRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/persons")
public class V1PersonController {

    private final PersonService personService;

    private final V1PersonControllerConverter converter;

    @Operation(summary = "Save new person", tags = {"v1-person-controller"})
    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody @Valid V1PersonRequestModel requestModel) {
        PersonDtoRequest personDtoRequest = converter.convertV1PersonRequestModelToPersonSaveDto(requestModel);
        personService.savePerson(personDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Person was saved");
    }
}
