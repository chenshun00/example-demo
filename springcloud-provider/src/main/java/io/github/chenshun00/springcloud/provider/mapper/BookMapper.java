package io.github.chenshun00.springcloud.provider.mapper;

//import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.chenshun00.springcloud.api.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 11:29 AM
 */
public interface BookMapper extends BaseMapper<Book> {

}
