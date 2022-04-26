package io.github.chenshun00.springcloud.consumer.ctrl;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 10:00 PM
 */
@RestController
public class TestCtrlImpl implements TestCtrl {

    @Override
    public String test() {
        return "good Test";
    }
}
