package io.github.chenshun00.springcloud.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author chenshun00@gmail.com
 * @since 2022/5/4 9:03 PM
 */
@JsonDeserialize(contentAs= Admin.class)
public interface User {

    String getName();

    String getPosition();

    int getAge();

}
