package io.github.chenshun00.springcloud.consumer.config;

import com.fasterxml.jackson.core.type.TypeReference;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import io.github.chenshun00.springcloud.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olegcherednik.jackson.utils.JacksonUtilsHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 10:32 AM
 */
@Configuration
public class KeepErrMsgConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }

    /**
     * 自定义错误
     */
    @Slf4j
    public static class UserErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                // 获取原始的返回内容
                String json = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                exception = new RuntimeException(json);
                // 将返回内容反序列化为Result，这里应根据自身项目作修改
                final Result<Void> result = JacksonUtilsHelper.createMapper().readValue(json, new TypeReference<>() {
                });
                // 业务异常抛出简单的 RuntimeException，保留原来错误信息
                if (!result.isSuccess()) {
                    exception = new RuntimeException(result.getMessage());
                }
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
            return exception;
        }
    }


}
