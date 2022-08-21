package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.chenshun00.springcloud.provider.test.index.bean.User;
import ru.olegcherednik.jackson.utils.JacksonUtilsHelper;

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
    public JsonNode convert(JsonNode root) {
        final User user = BeanUtil.copyProperties(root, this.type());
        return JacksonUtilsHelper.createMapper().valueToTree(user);
    }

}
