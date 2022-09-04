package io.github.chenshun00.springcloud.api;

import io.github.chenshun00.springcloud.dto.Admin;
import io.github.chenshun00.springcloud.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 9:28 PM
 */
@FeignClient(value = "nacos-provider", contextId = "helloController", fallback = BookFeign.BookFeignFailBack.class)
public interface BookFeign {

    @PostMapping(value = "/greeting?id=aa")
    String greeting(@RequestBody Admin user);

    @GetMapping("book")
    List<Book> getBookByAuthor(@RequestParam("author") String author);

    @GetMapping("user")
    String user(@SpringQueryMap User user);


    @Component
    class BookFeignFailBack implements BookFeign {

        @Override
        public String greeting(Admin user) {
            return "失败了";
        }

        @Override
        public List<Book> getBookByAuthor(String author) {
            return new ArrayList<>();
        }

        @Override
        public String user(User user) {
            return "失败了";
        }
    }
}
