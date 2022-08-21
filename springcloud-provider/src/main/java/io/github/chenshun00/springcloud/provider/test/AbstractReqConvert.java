package io.github.chenshun00.springcloud.provider.test;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:08 PM
 */
public abstract class AbstractReqConvert<T> {

    public abstract Class<T> type();

    public abstract JsonNode convert(JsonNode root);

}
