package org.jesperancinha.smtd.docker.boxing.old

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created by jofisaes on 31/03/2022
 */
@SpringBootApplication
class BoxingOldRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<BoxingOldRunner>(*args)
        }
    }
}
