package io.github.chenshun00.springcloud.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.chenshun00.springcloud.api.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 11:29 AM
 */
public interface BookMapper extends BaseMapper<Book> {

    @Select("select * from book where name = #{name}")
    Book findByName(@Param("name") String name);

}
