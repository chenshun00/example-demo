package io.chenshun00.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:28 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayExampleApplication.class);
    }
}
