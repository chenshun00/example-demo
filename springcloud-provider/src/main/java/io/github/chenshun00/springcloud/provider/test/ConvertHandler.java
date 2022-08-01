package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/1 11:12 PM
 */
@Component
public class ConvertHandler {

    private final Map<String, Convert> convertMap = new HashMap<>();

    @PostConstruct
    public void init() {
        final Set<Class<?>> classes = ClassScanner.scanAllPackageByAnnotation("io.github.chenshun00.springcloud.provider.test", CanConvert.class);
        for (Class<?> aClass : classes) {
            final Object o = ReflectUtil.newInstance(aClass);
            final CanConvert canConvert = aClass.getAnnotation(CanConvert.class);
            final Convert put = convertMap.put(canConvert.value(), (Convert) o);
            Assert.isNull(put, "convert value 重复出现:" + canConvert.value() + "\tclazz:" + aClass);
        }
    }

    public JSONObject handle(String clazz, JSONObject root) {
        final Convert convert = convertMap.get(clazz);
        Assert.notNull(convert, "转换工具不能为空");
        return convert.convert(root);
    }

}
