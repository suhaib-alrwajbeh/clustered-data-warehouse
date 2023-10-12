package com.fxdeals.ClusteredDataWarehouse.validation;

import com.fxdeals.ClusteredDataWarehouse.validation.impl.UniqueDealValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = UniqueDealValidator.class)
@Target({ TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueDeal {
    String message() default "This deal is already inserted";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
