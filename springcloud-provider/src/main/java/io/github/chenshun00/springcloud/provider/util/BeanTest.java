package io.github.chenshun00.springcloud.provider.util;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/21 3:33 PM
 */
@Value
public class BeanTest {
    @NonNull
    UUID bookId;
}
