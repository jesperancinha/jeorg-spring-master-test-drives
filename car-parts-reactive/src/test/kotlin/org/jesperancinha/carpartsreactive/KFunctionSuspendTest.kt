package org.jesperancinha.carpartsreactive

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.reflect.KFunction
import kotlin.reflect.full.callSuspend
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

class MyService2 {
    suspend fun fetchData(param: String): String = coroutineScope {
        "Fetched data for $param"
    }
}

class KFunctionSuspendTest {

    @Test
    fun `should run test of KFunction with function that suspends`(): Unit = runBlocking {
        val service = MyService2()
        val kFunction: KFunction<*> = MyService2::class.declaredFunctions.first { it.name == "fetchData" }
        kFunction.isAccessible = true
        runBlocking {
            val result = kFunction.callSuspend(service, "testParam") as String
            println(result)
        }
        println(service.fetchData(param = "Wow"))
    }

}