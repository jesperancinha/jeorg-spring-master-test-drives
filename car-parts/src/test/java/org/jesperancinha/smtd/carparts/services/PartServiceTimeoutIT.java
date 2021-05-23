package org.jesperancinha.smtd.carparts.services;

import org.jesperancinha.smtd.carparts.model.Part;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartServiceTimeoutIT {

    @Autowired
    private PartServiceTimeout partServiceTimeout;

    @Test
    public void testCreatePartWhenCreatePartThenSaveCorrectly() {
        final var engine = Part.builder().name("Engine").build();
        final var part = partServiceTimeout.createPart(engine);

        assertThat(part).isNotNull();
        assertThat(part.getName()).isEqualTo("Engine");
    }

    @Test
    public void testCreatePartTimeoutWhenCreatePartTimoutThenFail() {
        final var engine = Part.builder().name("Engine").build();
        assertThrows(JpaSystemException.class, () -> partServiceTimeout.createPartTimeout(engine));
    }

    @Test
    public void testCreatePartMixWhenCreatePartMixThenSave2TimesCorrectly() {
        final var engine = Part.builder().name("Engine").build();
        final var partMix = partServiceTimeout.createPartMix(engine);

        assertThat(partMix).isNotNull();
        assertThat(partMix.getName()).isEqualTo("Engine");
    }

    @Test
    public void testCreatePartExtraWhenCreatePartThenFail() {
        final var engine = Part.builder().name("Engine").build();
        assertThrows(JpaSystemException.class, () -> partServiceTimeout.createPartExtra(engine));
    }
}