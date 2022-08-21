package io.github.chenshun00.springcloud.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.api.HelloController;
import io.github.chenshun00.springcloud.dto.User;
import io.github.chenshun00.springcloud.provider.mapper.BookMapper;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.olegcherednik.jackson.utils.JacksonUtils;

import javax.annotation.Resource;
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


    @Value("${spring.bb}")
    private String hello;

    @RequestMapping("/")
    public String home() {
        System.out.println("hello==>" + hello);
        return hello;
    }

    @RequestMapping("one")
    public Object count() {
        final Long aLong = bookMapper.selectCount(new QueryWrapper<Book>().eq("author", "cc"));
        return aLong;
    }

    @RequestMapping("/echo")
    public String echo(String name) throws Throwable {
        if (StringUtils.isBlank(name)) {
            throw new Throwable("name is empty");
        }
        System.out.println("hello==>" + name);
        return "echo name = " + name;
    }

    @Override
    public String greeting() {
        return "hello " + "\t" + System.currentTimeMillis();
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        final Page<Book> objectPage = new Page<>(2, 1, false);
        final Page<Book> books = bookMapper.selectPage(objectPage, new QueryWrapper<Book>().eq("author", author));
        System.out.println(JacksonUtils.writeValue(books));
        return books.getRecords();
    }

    @Override
    public String user(User user) {
        System.out.println("AAA:==>" + JacksonUtils.writeValue(user));
        return "right";
    }

    @Resource
    private BookMapper bookMapper;
}
