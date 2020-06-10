package com.luyuze.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {

    int min() default 6;

    int max() default 16;

    String message() default "password are not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
