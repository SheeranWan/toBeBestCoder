package annotation.validated;

import annotation.UniqueCheck;
import annotation.ValueList;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 万明乐
 */
public class CheckValueList implements ConstraintValidator<ValueList, String>
{
    private Class<? extends Enum> enumClass;
    private String[] in;
    private String emField;
    private Class<?>[] group;

    @Override
    public void initialize(ValueList constraintAnnotation)
    {
        in = constraintAnnotation.in();
        enumClass = constraintAnnotation.em();
        emField = constraintAnnotation.emField();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return checkIn(value) || checkEm(value);
    }

    private boolean checkIn(String value)
    {
        if (value == null || in.length <= 0)
        {
            return false;
        }

        List<String> stringList = Arrays.asList(in);
        return stringList.contains(value);
    }

    private boolean checkEm(String value)
    {
        if (value == null || enumClass == Enum.class)
        {
            return false;
        }

        try
        {
            Enum[] enumConstants = enumClass.getEnumConstants();
            for (Enum enumConstant : enumConstants)
            {
                PropertyDescriptor pd = new PropertyDescriptor(emField,enumClass);
                String fieldValue = (String) pd.getReadMethod().invoke(enumConstant);
                if (fieldValue.equals(value))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }

        return false;
    }
}
