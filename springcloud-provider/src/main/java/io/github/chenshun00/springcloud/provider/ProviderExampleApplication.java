package io.github.chenshun00.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:13 AM
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan({"io.github.chenshun00.springcloud.provider.mapper"})
@ServletComponentScan("io.github.chenshun00.springcloud.provider")
public class ProviderExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderExampleApplication.class, args);
    }
}
