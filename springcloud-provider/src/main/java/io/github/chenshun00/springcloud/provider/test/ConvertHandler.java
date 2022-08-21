package io.github.chenshun00.springcloud.provider.test;

import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ReflectUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
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

    private final Map<String, AbstractReqConvert<?>> convertMap = new HashMap<>();

    @PostConstruct
    public void init() {
        final String name = this.getClass().getPackage().getName();
        final Set<Class<?>> classes = ClassScanner.scanAllPackageByAnnotation(name, CanConvert.class);
        Assert.notEmpty(classes, "扫描package获取class失败.");
        for (Class<?> aClass : classes) {
            final Object o = ReflectUtil.newInstance(aClass);
            final CanConvert canConvert = aClass.getAnnotation(CanConvert.class);
            String value = canConvert.value();
            if (StringUtils.isBlank(value)) {
                value = aClass.getSimpleName();
            }
            final AbstractReqConvert<?> put = convertMap.put(value, (Convert) o);
            Assert.isNull(put, "convert value 重复出现:" + canConvert.value() + "\tclazz:" + aClass);
        }
    }

    public JsonNode handle(String clazz, JsonNode root) {
        final AbstractReqConvert<?> convert = convertMap.get(clazz);
        Assert.notNull(convert, "转换工具不能为空");
        return convert.convert(root);
    }

}
