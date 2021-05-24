package org.jesperancinha.smtd.carparts.controller;

import org.jesperancinha.smtd.carparts.model.jpa.Part;
import org.jesperancinha.smtd.carparts.services.PartServiceTimeout;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PartController {

    private final PartServiceTimeout partServiceTimeout;

    public PartController(PartServiceTimeout partServiceTimeout) {
        this.partServiceTimeout = partServiceTimeout;
    }

    @RequestMapping("/parts")
    public void postNewPart(
            @RequestBody
            final Part part) {
        partServiceTimeout.createPart(part);
    }
}
