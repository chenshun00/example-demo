package io.github.chenshun00.springcloud.provider.ctrl;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 9:59 PM
 */
public interface TestCtrl {

    @GetMapping("test")
    String test();

}
