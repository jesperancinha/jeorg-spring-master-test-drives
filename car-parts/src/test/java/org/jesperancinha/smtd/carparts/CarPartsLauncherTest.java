package org.jesperancinha.smtd.carparts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarPartsLauncherTest {

    @Test
    void testContext() {
        CarPartsLauncher.main(new String[0]);
    }
}