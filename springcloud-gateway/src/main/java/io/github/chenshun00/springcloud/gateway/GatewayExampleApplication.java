package io.github.chenshun00.springcloud.gateway;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

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

    @RestController
    public static class A implements InitializingBean {

        @Value("${io.aa.cc}")
        private String value;

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(1);
        }
    }
}
