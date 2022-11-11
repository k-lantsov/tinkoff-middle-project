package com.company.personservice.controller.v1;

import com.company.personservice.controller.v1.converter.V1PersonControllerConverter;
import com.company.personservice.controller.v1.dto.person.V1PersonRequestModel;
import com.company.personservice.service.PersonService;
import com.company.personservice.service.dto.person.PersonRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@WebMvcTest(controllers = V1PersonController.class)
class V1PersonControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private V1PersonControllerConverter converter;
    @MockBean
    private PersonService personService;
    private V1PersonRequestModel requestModel;

    @BeforeEach
    void init() {
        requestModel = new V1PersonRequestModel();
        requestModel.setDocuments(Collections.emptySet());
        requestModel.setAddresses(Collections.emptySet());
        requestModel.setContacts(Collections.emptySet());
    }

    @Test
    void testSave_whenPersonDetailsProvided_returnSavePersonMessage() throws Exception {
        // arrange
        requestModel.setFirstname("Konstantin");
        requestModel.setLastname("Lantsov");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestModel));
        PersonRequestDto personRequestDto = new ModelMapper().map(requestModel, PersonRequestDto.class);

        doReturn(personRequestDto).when(converter).convertV1PersonRequestModelToPersonRequestDto(requestModel);
        doNothing().when(personService).savePerson(any());

        // act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String responseBodyAsString = mvcResult.getResponse().getContentAsString();

        // assert
        assertEquals(responseBodyAsString, "Person was saved");
    }

    @Test
    void testSave_whenPersonDetailsIncorrect_returnBadRequestStatusCode() throws Exception {
        // arrange
        requestModel.setFirstname("Konstantin");
        requestModel.setLastname("");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestModel));
        PersonRequestDto personRequestDto = new ModelMapper().map(requestModel, PersonRequestDto.class);

        doReturn(personRequestDto).when(converter).convertV1PersonRequestModelToPersonRequestDto(requestModel);
        doNothing().when(personService).savePerson(any());

        // act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        // assert
        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus(), "Http status code is not 400");
    }
}