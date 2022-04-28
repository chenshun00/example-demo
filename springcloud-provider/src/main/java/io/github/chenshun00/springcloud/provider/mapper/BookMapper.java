package io.github.chenshun00.springcloud.provider.mapper;

import io.github.chenshun00.springcloud.api.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 11:29 AM
 */
@Mapper
public interface BookMapper {

    List<Book> getBookByAuthor(@Param("author") String author);

}
