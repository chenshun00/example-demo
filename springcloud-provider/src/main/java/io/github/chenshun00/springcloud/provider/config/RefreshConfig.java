package io.github.chenshun00.springcloud.provider.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/11 11:07 PM
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "refresh")
@Data
public class RefreshConfig {

    private Set<String> common;

    private Boolean ifNeed;

    @LoadBalanced
    public void removeSomeKeyFromJson(JsonNode root) {
        if (ifNeed) {
            if (root instanceof ObjectNode) {
                ObjectNode obj = (ObjectNode) root;
                for (String s : common) {
                    obj.remove(s);
                }
            }
        }
    }
}
