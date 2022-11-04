package com.company.personservice.controller.v1;

import com.company.personservice.controller.v1.converter.V1PersonControllerConverter;
import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.controller.v1.dto.person.V1PersonWithDetailsResponseModel;
import com.company.personservice.controller.v1.dto.person.V1PersonWithoutDetailsResponseModel;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.dto.person.PersonWithDetailsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/persons")
public class V1PersonController {

    private final PersonService personService;

    private final V1PersonControllerConverter converter;

    @Operation(summary = "Save new person", tags = {"v1-person-controller"})
    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid V1PersonRequestModel requestModel) {
        personService.savePerson(converter.convertV1PersonRequestModelToPersonRequestDto(requestModel));
        return ResponseEntity.status(HttpStatus.CREATED).body("Person was saved");
    }

    @Operation(summary = "Get person information", tags = {"v1-person-controller"})
    @GetMapping(value = "/{uuid}")
    public ResponseEntity<V1PersonWithDetailsResponseModel> getPersonInfo(@PathVariable UUID uuid) {
        PersonWithDetailsResponseDto personWithDetailsResponseDto = personService.findByUuid(uuid);
        V1PersonWithDetailsResponseModel responseModel = converter.convertPersonWithDetailsResponseDtoToV1PersonResponseModel(personWithDetailsResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @Operation(summary = "Get all persons", tags = {"v1-person-controller"})
    @GetMapping
    public ResponseEntity<List<V1PersonWithoutDetailsResponseModel>> getAllPerson() {
        List<V1PersonWithoutDetailsResponseModel> responseModel = personService.findAll().stream()
                .map(converter::convertPersonWithoutDetailsResponseDtoToV1PersonWithoutDetailsResponseModel)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @Operation(summary = "Verify person", tags = {"v1-person-controller"})
    @GetMapping(value = "/verify")
    public ResponseEntity<Boolean> verifyPerson(@RequestParam String lastname, @RequestParam String documentType, @RequestParam String documentNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findByPersonLastname(lastname, documentType, documentNumber));
    }
}
