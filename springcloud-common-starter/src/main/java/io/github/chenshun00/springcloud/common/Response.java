package io.github.chenshun00.springcloud.common;

import lombok.Data;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 10:44 AM
 */
@Data
public class Response<T> {
    private Integer code;
    private boolean success;
    private String message;
    private T data;

}
