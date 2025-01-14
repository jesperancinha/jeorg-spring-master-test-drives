package org.jesperancinha.smtd

import java.lang.Thread.sleep
import java.rmi.RemoteException
import java.util.logging.Level
import java.util.logging.LogRecord
import kotlin.time.Duration.Companion.hours
import kotlin.time.toJavaDuration

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello and welcome!")
        for (i in 1..5) {
            println("i = $i")
        }
        println(RemoteException())
        if (args.isNotEmpty() && args[0] == "--keep") {
            sleep(1.hours.toJavaDuration())
        }
    }
}