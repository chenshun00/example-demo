package io.github.chenshun00.springcloud.api;

import org.springframework.stereotype.Component;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/22 10:29 PM
 */
@Component
public class TestFailBack implements TestFeign {

    @Override
    public Book pr() {
        Book book = new Book();
        book.setName("bad");
        return book;
    }
}
