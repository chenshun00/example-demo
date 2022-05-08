package io.github.chenshun00.springcloud.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableField("publish_date")
    private Date publishDate;

    private String name;
}
