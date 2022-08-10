package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.chenshun00.springcloud.provider.test.index.bean.User;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:05 PM
 */
@CanConvert("copy")
public class Convert extends AbstractReqConvert<User> {

    @Override
    public Class<User> type() {
        return User.class;
    }

    @Override
    public JSONObject convert(JSONObject root) {
        final User user = BeanUtil.copyProperties(root, this.type());
        return (JSONObject) JSON.toJSON(user);
    }

}
