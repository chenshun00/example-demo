package io.github.chenshun00.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/21 10:16 PM
 */
@FeignClient(value = "nacos-provider", contextId = "testFeign")
public interface TestFeign {
    @PostMapping("/timeout/three")
    Book pr();
}
