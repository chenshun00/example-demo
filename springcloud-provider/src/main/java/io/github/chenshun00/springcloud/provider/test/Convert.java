package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:05 PM
 */
public class Convert extends AbstractReqConvert<Copy.User> {

    @Override
    public Class<Copy.User> type() {
        return Copy.User.class;
    }

    @Override
    public JSONObject convert(JSONObject root) {
        final Copy.User user = BeanUtil.copyProperties(root, this.type());
        return (JSONObject) JSON.toJSON(user);
    }

}
