package io.github.chenshun00.springcloud.provider.config;

import cn.hutool.core.date.DateUtil;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

/**
 * @author chenshun00@gmail.com
 * @since 2022/7/9 11:31 AM
 */
@Configuration
public class NacosConfig {

    @Bean
    public NacosDiscoveryProperties nacosDiscoveryProperties() {
        NacosDiscoveryProperties nacosDiscoveryProperties = new NacosDiscoveryProperties();
        final Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();
        metadata.put("startup.time", DateUtil.formatDateTime(new Date()));

        final String userHome = System.getProperty("user.home");
        if (StringUtils.isBlank(userHome)) {
            metadata.put("user.home", "empty");
        } else {
            metadata.put("user.home", userHome);
        }
        return nacosDiscoveryProperties;
    }


}
