package org.jesperancinha.smtd.service

import io.micrometer.common.KeyValue
import io.micrometer.observation.Observation.Context
import io.micrometer.observation.ObservationHandler
import io.micrometer.observation.annotation.Observed
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.stream.StreamSupport
import kotlin.random.Random


@Service
internal class GMService {
    private val random = Random
    @Observed(
        name = "user.name",
        contextualName = "getting-user-name",
        lowCardinalityKeyValues = ["userType", "userType2"]
    )
    fun userName(userId: String?): String {
        log.info("Getting user name for user with id <{}>", userId)
        try {
            Thread.sleep(random.nextLong(200L)) // simulates latency
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        return "foo"
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(GMService::class.java)
    }
}

@Component
internal class MyHandler : ObservationHandler<Context> {
    override fun onStart(context: Context) {
        log.info(
            "Before running the observation for context [{}], userType [{}]",
            context.name,
            getUserTypeFromContext(context)
        )
    }

    override fun onStop(context: Context) {
        log.info(
            "After running the observation for context [{}], userType [{}]",
            context.name,
            getUserTypeFromContext(context)
        )
    }

    override fun supportsContext(context: Context): Boolean {
        return true
    }

    private fun getUserTypeFromContext(context: Context): String {
        return StreamSupport.stream(context.lowCardinalityKeyValues.spliterator(), false)
            .filter { keyValue: KeyValue -> "userType" == keyValue.key }
            .map(KeyValue::getValue)
            .findFirst()
            .orElse("UNKNOWN")
    }

    companion object {
        private val log = LoggerFactory.getLogger(MyHandler::class.java)
    }
}