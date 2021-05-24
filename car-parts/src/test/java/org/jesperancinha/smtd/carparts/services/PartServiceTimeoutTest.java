package org.jesperancinha.smtd.carparts.services;

import org.jesperancinha.smtd.carparts.model.jpa.Part;
import org.jesperancinha.smtd.carparts.repos.PartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PartServiceTimeoutTest {

    @InjectMocks
    private PartServiceTimeout partServiceTimeout;

    @Mock
    private PartRepository partRepository;

    @Captor
    private ArgumentCaptor<Part> partArgumentCaptor;

    @Test
    public void testCreatePartWhenCreatePartThenSaveCorrectly() {
        final var engine = Part.builder().name("Engine").build();
        when(partRepository.save(engine)).thenReturn(engine);

        final var part = partServiceTimeout.createPart(engine);

        assertThat(part).isNotNull();
        assertThat(part.getName()).isEqualTo("Engine");
        verify(partRepository, only()).save(partArgumentCaptor.capture());
        assertThat(partArgumentCaptor.getValue()).isEqualTo(engine);
    }

    /**
     * Since this is just a unit test, no timeout will be generated
     * The annotation {@link org.springframework.transaction.annotation.Transactional}, has no effect in this case.
     */
    @Test
    public void testCreatePartTimeoutWhenCreatePartTimoutThenOK() {
        final var engine = Part.builder().name("Engine").build();
        when(partRepository.save(engine)).thenReturn(engine);

        final var part = partServiceTimeout.createPartTimeout(engine);

        assertThat(part).isNotNull();
        assertThat(part.getName()).isEqualTo("Engine");
        verify(partRepository, only()).save(partArgumentCaptor.capture());
        assertThat(partArgumentCaptor.getValue()).isEqualTo(engine);
    }

    @Test
    public void testCreatePartMixWhenCreatePartMixThenSave2TimesCorrectly() {
        final var engine = Part.builder().name("Engine").build();
        when(partRepository.save(engine)).thenReturn(engine);

        final var partMix = partServiceTimeout.createPartMix(engine);

        assertThat(partMix).isNotNull();
        assertThat(partMix.getName()).isEqualTo("Engine");
        verify(partRepository, times(2)).save(partArgumentCaptor.capture());
        final var allValues = partArgumentCaptor.getAllValues();
        assertThat(allValues).hasSize(2);
        assertAll(
                () -> assertThat(allValues.get(0)).isEqualTo(engine),
                () -> assertThat(allValues.get(1)).isEqualTo(engine)
        );
    }

    /**
     * Since this is just a unit test, no timeout will be generated
     * The annotation {@link org.springframework.transaction.annotation.Transactional}, has no effect in this case.
     */
    @Test
    public void testCreatePartExtraWhenCreatePartThenOk() {
        final var engine = Part.builder().name("Engine").build();
        when(partRepository.save(engine)).thenReturn(engine);

        final var part = partServiceTimeout.createPartExtra(engine);

        assertThat(part).isNotNull();
        assertThat(part.getName()).isEqualTo("Engine");
        verify(partRepository, only()).save(partArgumentCaptor.capture());
        assertThat(partArgumentCaptor.getValue()).isEqualTo(engine);
    }
}