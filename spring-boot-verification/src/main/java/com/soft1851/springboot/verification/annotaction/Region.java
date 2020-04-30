package com.soft1851.springboot.verification.annotaction;


import com.soft1851.springboot.verification.util.RegionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RegionValidator.class)
public @interface Region {

    String message() default "Region值不在可选范围内";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default  {};
}
