package org.jesperancinha.smtd

import java.lang.Thread.sleep
import kotlin.time.Duration.Companion.hours
import kotlin.time.toJavaDuration

object SimpleCdsApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello and welcome!")
        for (i in 1..5) {
            println("i = $i")
        }
        if (args.isNotEmpty() && args[0] == "--keep") {
            sleep(1.hours.toJavaDuration())
        }

        // This is part of the Example! It works with custom build. Please check the Makefile of this project for more
        //org.jesperancinha.smtd.utils.Auxiliary.printJavatoConsole("ThisWorks!")
    }
}