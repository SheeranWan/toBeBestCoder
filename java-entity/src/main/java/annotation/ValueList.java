package annotation;

import annotation.validated.CheckValueList;
import annotation.validated.UniqueCheckValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验参数允许值
 * @author SheeranWan
 */
@Documented
@Constraint(validatedBy = CheckValueList.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValueList
{
    String message() default "value not included";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String[] in() default {};

    Class<? extends Enum> em() default Enum.class;

    String emField() default "name";
}
