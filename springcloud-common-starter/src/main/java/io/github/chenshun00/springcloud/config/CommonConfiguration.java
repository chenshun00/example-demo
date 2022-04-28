package io.github.chenshun00.springcloud.config;

import feign.RequestInterceptor;
import io.github.chenshun00.springcloud.common.FeignRequestInterceptor;
import io.github.chenshun00.springcloud.common.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 10:47 AM
 */
@Configuration
public class CommonConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    @ConditionalOnClass(RequestInterceptor.class)
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
