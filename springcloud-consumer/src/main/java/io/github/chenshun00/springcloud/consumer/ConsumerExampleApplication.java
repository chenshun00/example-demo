package io.github.chenshun00.springcloud.consumer;

import io.github.chenshun00.springcloud.api.BookFeign;
import io.github.chenshun00.springcloud.dto.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:16 AM
 */
@SpringBootApplication(scanBasePackages = {"io.github.chenshun00.springcloud.api", "io.github.chenshun00.springcloud.consumer"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.github.chenshun00.springcloud.api"})
@EnableHystrix
public class ConsumerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerExampleApplication.class);
    }

    @RestController
    @RefreshScope
    public static class ConsulController {

        @Resource
        private BookFeign bookFeign;

        @GetMapping("/gg")
        public String ok() {
            final Admin user = new Admin();
            user.setName("cc");
            user.setPosition("11");
            user.setAge(22);
            return bookFeign.greeting(user);
        }
    }
}
