package org.jesperancinha.smtd.carparts

import org.jesperancinha.smtd.carparts.services.SingletonBean
import org.jesperancinha.smtd.carparts.services.SingletonBean2
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
class CarPartsKotlinLauncher(val singletonBean: SingletonBean, val singletonBean2: SingletonBean2) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
       println(singletonBean.prototypeId)
       println(singletonBean2.prototypeId)
    }

}
fun main(args: Array<String>) {
    SpringApplication.run(CarPartsKotlinLauncher::class.java, *args)
}