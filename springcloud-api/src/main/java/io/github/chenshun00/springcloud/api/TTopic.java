package io.github.chenshun00.springcloud.api;

import lombok.Data;

/**
 * @author chenshun00@gmail.com
 * @since 2022/5/22 2:23 PM
 */
@Data
public class TTopic {
    Long id;
    String topic;
    Integer state;
    Integer connect;
    Boolean isPrintLog;
}
