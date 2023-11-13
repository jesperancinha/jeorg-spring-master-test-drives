package org.jesperancinha.thevalidationcompany.fiveminutes.custom

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import org.springframework.beans.BeanWrapperImpl
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@AtLeastOne(fields = ["postAddress", "street"], message = "You need to fill in your postAddress or your street")
data class AccountCustomDto(
    val postAddress: String?,
    val street: String?,
    val houseNumber: Long?,
    val postCode: String
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Constraint(validatedBy = [OneAtLeastNotNullConstraintValidator::class])
annotation class AtLeastOne(
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val message: String = "Object instance of violates one not null constraint",
    val fields: Array<String> = []
)

@Component
class OneAtLeastNotNullConstraintValidator : ConstraintValidator<AtLeastOne, Any> {
    private lateinit var fields: Array<String>

    override fun initialize(configuration: AtLeastOne) {
        fields = configuration.fields
    }

    override fun isValid(obj: Any, context: ConstraintValidatorContext): Boolean {
        val beanWrapper = BeanWrapperImpl(obj)
        return fields
            .mapNotNull { propertyName -> beanWrapper.getPropertyValue(propertyName) }
            .count() >= 1L
    }
}
