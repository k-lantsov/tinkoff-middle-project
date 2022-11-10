package com.company.personservice.controller.v1;

import com.company.personservice.entity.enums.AddressType;
import com.company.personservice.entity.enums.ContactType;
import com.company.personservice.entity.enums.DocumentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class V1PersonControllerAcceptanceTest {

    @LocalServerPort
    private int localServerPort;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        System.out.println("local server port = " + localServerPort);
    }

    @Test
    void testSave_whenValidPersonDetailsProvided_thenReturnSuccessMessage() throws JSONException {
        // arrange
        JSONObject personDetailsRequestJson = new JSONObject();
        personDetailsRequestJson.put("firstname", "Leon");
        personDetailsRequestJson.put("lastname", "Lantsov");

        JSONObject documentDetailsRequestJson = new JSONObject();
        documentDetailsRequestJson.put("documentNumber", "MP8800088");
        documentDetailsRequestJson.put("documentType", DocumentType.PASSPORT.name());
        JSONArray documentsRequestJsonArray = new JSONArray();
        documentsRequestJsonArray.put(documentDetailsRequestJson);
        personDetailsRequestJson.put("documents", documentsRequestJsonArray);

        JSONObject addressDetailsRequestJson = new JSONObject();
        addressDetailsRequestJson.put("country", "Belarus");
        addressDetailsRequestJson.put("locality", "Minsk");
        addressDetailsRequestJson.put("street", "Krasina");
        addressDetailsRequestJson.put("houseNumber", 24);
        addressDetailsRequestJson.put("apartmentsNumber", 79);
        addressDetailsRequestJson.put("postcode", "220109");
        addressDetailsRequestJson.put("addressType", AddressType.ACTUAL.name());
        JSONArray addressesRequestJsonArray = new JSONArray();
        addressesRequestJsonArray.put(addressDetailsRequestJson);
        personDetailsRequestJson.put("addresses", addressesRequestJsonArray);

        JSONObject contactDetailsRequestJson = new JSONObject();
        contactDetailsRequestJson.put("contactType", ContactType.PHONE_NUMBER.name());
        contactDetailsRequestJson.put("contactValue", "+375447858303");
        JSONArray contactsRequestJsonArray = new JSONArray();
        contactsRequestJsonArray.put(contactDetailsRequestJson);
        personDetailsRequestJson.put("contacts", contactsRequestJsonArray);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(personDetailsRequestJson.toString(), headers);

        // act
        ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/persons", request, String.class);

        // assert
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals("Person was saved", response.getBody())
        );
    }
}
