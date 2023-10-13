package com.fxdeals.ClusteredDataWarehouse.validation;

import com.fxdeals.ClusteredDataWarehouse.validation.impl.ISOCurrencyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = ISOCurrencyValidator.class)
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ISOCurrency {
    String message() default "Invalid ISO currency code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
