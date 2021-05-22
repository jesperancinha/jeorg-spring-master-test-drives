package org.jesperancinha.smtd.carparts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CarPartsLauncherTest {

    @Test
    void testContext() {
        CarPartsLauncher.main(new String[0]);
    }
}