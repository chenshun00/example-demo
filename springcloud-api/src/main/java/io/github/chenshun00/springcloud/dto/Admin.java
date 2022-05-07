package io.github.chenshun00.springcloud.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chenshun00@gmail.com
 * @since 2022/5/4 9:04 PM
 */
@Getter
@Setter
@ToString
public class Admin implements User {

    private String name;
    private String position;
    private int age;
}
