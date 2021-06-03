package org.jesperancinha.smtd.carparts.repos;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Creating nested classes in java interfaces
 *
 * @author jofisaes
 */
public class PartRepositoryTest {

    @Test
    public void testInnerNestedClassInInterface() {
        final PartRepository.InternalPartRepository internalPartRepository = new PartRepository.InternalPartRepository();
        assertThat(internalPartRepository).isNotNull();
    }

}