package io.github.chenshun00.springcloud.provider.util;

import lombok.NonNull;
import lombok.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.util.UUID;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/21 3:33 PM
 */
@Value
public class BeanTest {
    @NonNull
            @LoadBalanced
    UUID bookId;
}
