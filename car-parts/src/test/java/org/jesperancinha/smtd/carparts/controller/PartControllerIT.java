package org.jesperancinha.smtd.carparts.controller;

import org.jesperancinha.smtd.carparts.model.Part;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PartControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testPostNewPartWhenSendingNoTimeoutReturnGoodOk() {
        final var engine = Part.builder().name("Engine").build();

        final var partResponseEntity =
                testRestTemplate.postForEntity("/parts", engine, Part.class);

        assertThat(partResponseEntity).isNotNull();
        assertThat(partResponseEntity.getBody()).isNull();
    }
}