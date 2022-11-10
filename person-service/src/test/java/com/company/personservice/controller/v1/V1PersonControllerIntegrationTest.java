package com.company.personservice.controller.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class V1PersonControllerIntegrationTest {

    @LocalServerPort
    private int localServerPort;

    @Test
    void contextLoads() {
        System.out.println("local server port = " + localServerPort);
    }
}
