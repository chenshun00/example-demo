package io.github.chenshun00.springcloud.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 10:42 AM
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public Response<Void> exception(Exception e) {
        log.error("[程序发生通用异常][error:{}]", e.getMessage(), e);
        Response<Void> response = new Response<>();
        response.setCode(200);
        response.setMessage(e.getMessage());
        response.setSuccess(false);
        return response;
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public Response<Void> npe(NullPointerException e) {
        log.error("[程序发生空指针异常][error:{}]", e.getMessage(), e);
        Response<Void> response = new Response<>();
        response.setCode(201);
        response.setMessage("程序发生空指针异常");
        response.setSuccess(false);
        return response;
    }
}
