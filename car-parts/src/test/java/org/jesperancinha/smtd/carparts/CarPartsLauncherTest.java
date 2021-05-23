package org.jesperancinha.smtd.carparts;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.carparts.controller.PartController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarPartsLauncherTest {

    @Autowired
    private PartController partController;

    @Test
    public void testContext() {
        CarPartsLauncher.main(new String[0]);

        ConsolerizerComposer.outSpace()
                .unicorns(100)
                .orange("Never do this in production!!!")
                .orange("This is just to show that we can Inject Controller, RestController or Component.")
                .orange("A RestController is also a Controller, which is also a Component.")
                .orange("This means that we can inject this:")
                .orange(partController)
                .jsonPrettyPrint(partController)
                .unicorns(100)
                .reset();

    }
}