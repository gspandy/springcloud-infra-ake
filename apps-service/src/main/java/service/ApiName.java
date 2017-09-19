package service;

import java.lang.annotation.*;

/**
 * Created by breeze on 2016/12/21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface ApiName {
    String value() default "";
}
