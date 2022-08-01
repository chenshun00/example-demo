package io.github.chenshun00.springcloud.provider.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author chenshun00@gmail.com
 * @since 2022/7/26 10:24 PM
 */
public class FF extends PatternLayout {

    @Override
    public String doLayout(ILoggingEvent event) {
        return Thread.currentThread().getName() + "\t" + TraceUtil.get() + "\t" + event.getFormattedMessage() + "\t\n";
    }
}
