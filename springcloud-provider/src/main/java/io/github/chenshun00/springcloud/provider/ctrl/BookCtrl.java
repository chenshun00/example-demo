package io.github.chenshun00.springcloud.provider.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.dto.Admin;
import io.github.chenshun00.springcloud.dto.User;
import io.github.chenshun00.springcloud.provider.mapper.BookMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.olegcherednik.jackson.utils.JacksonUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试
 *
 * @author chenshun00@gmail.com
 * @since 2022/4/26 10:00 PM
 */
@RestController
public class BookCtrl {

    @Resource
    private BookMapper bookMapper;

    @PostMapping(value = "greeting", params = "id=aa")
    public String greeting(@RequestBody Admin user) throws InterruptedException {
        System.out.println("11");
        Thread.sleep(30000);
        return "11";
    }

    @GetMapping("book")
    public List<Book> getBookByAuthor(String author) {
        final Page<Book> objectPage = new Page<>(2, 1, false);
        final Page<Book> books = bookMapper.selectPage(objectPage, new QueryWrapper<Book>().eq("author", author));
        System.out.println(JacksonUtils.writeValue(books));
        return books.getRecords();
    }

    @GetMapping("user")
    public String user(User user) {
        System.out.println("AAA:==>" + JacksonUtils.writeValue(user));
        return "right";
    }
}