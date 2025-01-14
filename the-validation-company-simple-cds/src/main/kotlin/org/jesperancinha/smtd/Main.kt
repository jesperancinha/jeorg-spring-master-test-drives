package org.jesperancinha.smtd

import java.lang.Thread.sleep
import kotlin.time.Duration.Companion.hours
import kotlin.time.toJavaDuration

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello and welcome!")
        for (i in 1..5) {
            println("i = $i")
        }
        if (args.isNotEmpty() && args[0] == "--keep") {
            sleep(1.hours.toJavaDuration())
        }

//        org.jesperancinha.smtd.utils.Utility.printValue("ThisWorks!")
    }
}