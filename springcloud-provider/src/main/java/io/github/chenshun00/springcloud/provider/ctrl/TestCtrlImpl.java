package io.github.chenshun00.springcloud.provider.ctrl;

import io.github.chenshun00.springcloud.provider.service.TTopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 10:00 PM
 */
@RestController
@Slf4j
public class TestCtrlImpl {

    @Resource
    private TTopicService tTopicService;

    @GetMapping("one")
    public Object one() {
        return tTopicService.getOne();
    }

    @GetMapping("test")
    public Object test() {
        log.info("hhh22");
        tTopicService.add();
        log.info("hhh11");
        return "ok";
    }


}
