package io.github.chenshun00.springcloud.provider;

import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.api.HelloController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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
    public static class ConsulController {

        @Resource
        private HelloController helloController;
        @Resource
        private LoadBalancerClient loadBalancerClient;
        @Resource
        private RestTemplate restTemplate;

        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("feign")
        public List<Book> feign() {
            return helloController.getBookByAuthor("cc");
        }

        @GetMapping("/")
        public String ok() {
            return "ok";
        }
    }

    //实例化 RestTemplate 实例
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
