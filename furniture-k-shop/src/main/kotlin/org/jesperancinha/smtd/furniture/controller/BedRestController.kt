package org.jesperancinha.smtd.furniture.controller

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import jakarta.validation.Valid
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.dto.ChairDto
import org.jesperancinha.smtd.furniture.service.ChairDtoValidator
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*


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


    @InitBinder
    fun customizeBinding(binder: WebDataBinder) {
        binder.addValidators(ChairDtoValidator())
    }

    @GetMapping(path = ["/beds"])
    fun bedCountCall(): Double {
        bedCount.increment()
        return bedCount.count()
    }

    @PostMapping(path = ["chairs"])
    fun createChair(@Valid @RequestBody chair: ChairDto){

    }
}
