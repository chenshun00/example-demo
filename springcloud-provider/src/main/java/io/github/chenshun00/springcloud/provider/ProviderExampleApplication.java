package io.github.chenshun00.springcloud.provider;

import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.api.HelloController;
import io.github.chenshun00.springcloud.provider.mapper.BookMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:13 AM
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@MapperScan(basePackages = {"io.github.chenshun00.springcloud.provider"})
public class ProviderExampleApplication implements HelloController {
    public static void main(String[] args) {
        SpringApplication.run(ProviderExampleApplication.class, args);
    }


    @Value("${fname.fchen}")
    private String hello;

    @RequestMapping("/")
    public String home() {
        System.out.println("hello==>" + hello);
        return "Hello world";
    }

    @RequestMapping("/echo/{name}")
    public String echo(@PathVariable String name) {
        System.out.println("hello==>" + name);
        return "echo name = " + name;
    }

    @Override
    public String greeting() {
        return "hello " + "\t" + System.currentTimeMillis();
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return bookMapper.getBookByAuthor(author);
    }

    @Resource
    private BookMapper bookMapper;
}
