package org.jesperancinha.smtd.docker.boxing.port

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

/**
 * Created by jofisaes on 31/03/2022
 */
@SpringBootApplication
class BoxingOldRunner : ApplicationRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            logger.info("Starting server -> ${LocalDateTime.now()}")
            Thread.sleep(TimeUnit.SECONDS.toMillis(2))
            runApplication<BoxingOldRunner>(*args)
        }

        val logger: Logger = LoggerFactory.getLogger(BoxingOldRunner::class.java)
        val startup = LocalDateTime.now()
    }

    override fun run(args: ApplicationArguments?) {
        logger.info("Service started -> ${LocalDateTime.now()}")
        logger.info("Time Elapsed -> ${ChronoUnit.MILLIS.between(startup, LocalDateTime.now())} ms")
    }
}
