package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 10:49 PM
 */
public class Copy {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", 10);

        Car car = new Car("luntai", "zhuji");
        jsonObject.put("car", car);

        final User user = BeanUtil.copyProperties(jsonObject, User.class);
        final JSONObject json = (JSONObject) JSONObject.toJSON(user);
        System.out.println(json);
    }

    @Data
    public static class User {
        private Integer age;
        private Car car;
    }

    @Data
    @AllArgsConstructor
    public static class Car {
        private String luntai;
        private String zhuji;
    }

}
