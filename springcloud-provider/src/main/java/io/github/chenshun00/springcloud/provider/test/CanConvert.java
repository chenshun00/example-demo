package io.github.chenshun00.springcloud.provider.test;

import java.lang.annotation.*;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:14 PM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CanConvert {

    String value();

}
