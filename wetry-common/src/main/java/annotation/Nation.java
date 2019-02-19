package annotation;

import java.lang.annotation.*;

/**
 * Created by wch on 18-8-16.
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface Nation {
    String value() default "han";
}
