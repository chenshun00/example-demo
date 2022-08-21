package io.github.chenshun00.springcloud.consumer;

import io.github.chenshun00.springcloud.api.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:16 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.github.chenshun00.springcloud.api"})
public class ConsumerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerExampleApplication.class);
    }


    @RestController
    @RefreshScope
    public static class ConsulController {

        @Resource
        private HelloController helloController;

        @GetMapping("/")
        public String ok() {
            return "ok";
        }
    }
}
