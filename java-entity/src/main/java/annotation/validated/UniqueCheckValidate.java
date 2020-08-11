package annotation.validated;

import annotation.UniqueCheck;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 万明乐
 */
public class UniqueCheckValidate implements ConstraintValidator<UniqueCheck, List>
{
    private Class<?> clazz;
    private String field;

    @Override
    public void initialize(UniqueCheck constraintAnnotation)
    {
        clazz = constraintAnnotation.clazz();
        field = constraintAnnotation.field();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(List dataList, ConstraintValidatorContext context)
    {
        if (CollectionUtils.isEmpty(dataList))
        {
            return true;
        }

        try
        {
            Class<?> aClass = CollectionUtils.findCommonElementType(dataList);
            if (aClass == null || StringUtils.isEmpty(field))
            {
                return false;
            }
            if (!clazz.isAssignableFrom(aClass))
            {
                return false;
            }

            dataList.stream().collect(Collectors.toMap(obj -> {
                PropertyDescriptor pd = null;
                try
                {
                    pd = new PropertyDescriptor(field,clazz);
                    return pd.getReadMethod().invoke(obj);
                }
                catch (Exception e)
                {
                    return "";
                }
            }, o -> o));
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
}
