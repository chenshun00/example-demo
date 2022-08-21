package io.github.chenshun00.springcloud.consumer.ctrl;

import io.github.chenshun00.springcloud.api.TestFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/21 10:17 PM
 */
@RestController
public class TestCtrl {

    @Resource
    private TestFeign testFeign;

    @GetMapping("/time/out")
    public Object timeout() {
        try {
            return testFeign.pr();
        } catch (Exception e) {
            e.printStackTrace();
            return "exception:" + e.getMessage();
        }
    }

}
