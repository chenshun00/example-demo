package io.github.chenshun00.springcloud.provider;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.api.HelloController;
import io.github.chenshun00.springcloud.dto.User;
import io.github.chenshun00.springcloud.provider.mapper.BookMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 11:13 AM
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@EnableDiscoveryClient
@RefreshScope
@MapperScan({"io.github.chenshun00.springcloud.provider.mapper"})
@ServletComponentScan("io.github.chenshun00.springcloud.provider")
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

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("dd")
    public void dd() {
        final String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        System.out.println("===开始输出");
        for (String s : beanNamesForType) {
            System.out.println("数据源类型:" + s);
        }
    }

    @Override
    public String greeting() {
        return "hello " + "\t" + System.currentTimeMillis();
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        final Page<Book> objectPage = new Page<>(2, 1, false);
        final Page<Book> books = bookMapper.selectPage(objectPage, new QueryWrapper<Book>().eq("author", author));
        System.out.println(JSONObject.toJSONString(books));
        return books.getRecords();
    }

    @Override
    public String user(User user) {
        System.out.println("AAA:==>" + JSONObject.toJSONString(user));
        return "right";
    }

    @Resource
    private BookMapper bookMapper;
}
