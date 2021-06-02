package org.jesperancinha.smtd.furniture.controller

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BedRestController(
    private val meterRegistry: MeterRegistry
) {

    private var bedOrder: Counter
    private var bedCount: Counter

    init {
        ConsolerizerComposer.outSpace()
            .magenta(meterRegistry)
         bedCount = this.meterRegistry.counter("bed.orders", "type", "box")
         bedOrder = Counter.builder("bed.orders")
            .tag("type", "box")
            .description("Total orders for beds")
            .register(meterRegistry);
    }

    @GetMapping(path = ["/beds"])
    fun bedCountCall(): Double {
        bedCount.increment()
        return bedCount.count()
    }
}
