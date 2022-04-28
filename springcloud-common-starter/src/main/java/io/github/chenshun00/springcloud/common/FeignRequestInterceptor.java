package io.github.chenshun00.springcloud.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/28 10:45 AM
 */
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("traceId", UUID.randomUUID().toString());
    }
}
