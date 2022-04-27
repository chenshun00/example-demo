package io.github.chenshun00.springcloud.api;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenshun00@gmail.com
 * @since 2022/4/27 11:25 AM
 */
@Data
public class Book implements Serializable {

    private Integer id;

    private String author;

    private Date publishDate;

    private String name;
}
