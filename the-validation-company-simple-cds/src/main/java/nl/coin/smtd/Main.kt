package nl.coin.smtd

import java.lang.Thread.sleep
import kotlin.time.Duration.Companion.hours
import kotlin.time.toJavaDuration

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.printf("Hello and welcome!")
        for (i in 1..5) {
            println("i = " + i)
        }
        if(args.size > 0 && args.get(0) == "--keep") {
            sleep(1.hours.toJavaDuration())
        }
    }
}