package io.github.chenshun00.springcloud.provider.test;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:14 PM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface CanConvert {

    String value() default "";

}
