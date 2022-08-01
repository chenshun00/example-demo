package io.github.chenshun00.springcloud.provider.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:08 PM
 */
public abstract class AbstractReqConvert<T> {

    public abstract Class<T> type();

    public abstract JSONObject convert(JSONObject root);

}
