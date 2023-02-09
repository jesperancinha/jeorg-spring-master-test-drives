package org.jesperancinha.smtd.configuration

import io.micrometer.observation.Observation

import io.micrometer.observation.ObservationRegistry
import org.springframework.stereotype.Component


@Component
class GMConfiguration(observationRegistry: ObservationRegistry) {
    private val observationRegistry: ObservationRegistry

    init {
        this.observationRegistry = observationRegistry
    }

    fun doSomething() {
        Observation.createNotStarted("doSomething", observationRegistry)
            .lowCardinalityKeyValue("locale", "en-US")
            .highCardinalityKeyValue("userId", "42")
            .observe {

            }
    }
}