package io.github.chenshun00.springcloud.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 11:25 AM
 */
@Data
@TableName("book")
public class Book implements Serializable {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String author;

    @JsonProperty("publish_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @TableField("publish_date")
    private Date publishDate;

    private String name;

    public static Book of() {
        final Book book = new Book();
        book.setId(1);
        book.setName("book_name");
        return book;
    }
}
