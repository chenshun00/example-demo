package io.github.chenshun00.springcloud.provider.util;

import cn.hutool.core.lang.UUID;
import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author chenshun00@gmail.com
 * @since 2022/7/26 10:18 PM
 */
public class TraceUtil {

    private final static TransmittableThreadLocal<String> TRACE = new TransmittableThreadLocal<>();

    public static String get() {

        String traceId = TRACE.get();
        if (traceId == null) {
            traceId = UUID.randomUUID().toString(true);
            TRACE.set(traceId);
        }
        return traceId;
    }

    public static void clear() {
        TRACE.remove();
    }




    public static void init() {
        TRACE.set(UUID.randomUUID().toString(true));
    }

}
