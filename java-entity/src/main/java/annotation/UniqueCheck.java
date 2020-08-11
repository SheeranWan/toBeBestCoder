package annotation;

import annotation.validated.UniqueCheckValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验参数唯一
 * @author SheeranWan
 */
@Documented
@Constraint(validatedBy = UniqueCheckValidate.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueCheck
{
    String message() default "value assigned needs to be unique";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> clazz() default Object.class;

    String field() default "";
}
