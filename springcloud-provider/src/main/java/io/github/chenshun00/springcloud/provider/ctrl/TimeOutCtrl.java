package io.github.chenshun00.springcloud.provider.ctrl;

import io.github.chenshun00.springcloud.api.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/21 8:22 PM
 */
@RestController()
@RequestMapping("timeout")
@Slf4j
public class TimeOutCtrl {

    @PostMapping("three")
    public Book three() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ignore) {
        }
        log.info("[query]");
        return Book.of();
    }

}
