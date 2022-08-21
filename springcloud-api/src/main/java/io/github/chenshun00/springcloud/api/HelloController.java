package io.github.chenshun00.springcloud.api;

import io.github.chenshun00.springcloud.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/26 9:28 PM
 */
@FeignClient(value = "nacos-provider", contextId = "helloController")
public interface HelloController {

    @GetMapping("/greeting")
    String greeting();

    @GetMapping("book")
    List<Book> getBookByAuthor(@RequestParam("author") String author);

    @GetMapping("user")
    String user(@SpringQueryMap User user);
}
