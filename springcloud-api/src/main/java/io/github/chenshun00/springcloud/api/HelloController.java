package io.github.chenshun00.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 9:28 PM
 */
@FeignClient("consul-provider")
public interface HelloController {

    @RequestMapping("/greeting")
    String greeting();
}
