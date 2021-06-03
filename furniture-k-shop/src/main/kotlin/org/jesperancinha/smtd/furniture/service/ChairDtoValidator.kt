package org.jesperancinha.smtd.furniture.service

import org.jesperancinha.smtd.furniture.dto.ChairDto
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Created by jofisaes on 03/06/2021
 */
class ChairDtoValidator: Validator {
    override fun supports(p0: Class<*>): Boolean {
       return ChairDto::class.java == p0;
    }
    override fun validate(p0: Any, p1: Errors) {
        val designation = (p0 as ChairDto).designation
        if(designation == null){
            p1.rejectValue("designation","not a chair")
        } else {
            if (!designation.startsWith("CHAIR")) {
                p1.rejectValue("designation", "not a chair")
            }
        }
    }
}