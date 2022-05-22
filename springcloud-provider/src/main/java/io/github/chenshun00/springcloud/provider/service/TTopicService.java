package io.github.chenshun00.springcloud.provider.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import io.github.chenshun00.springcloud.api.TTopic;
import io.github.chenshun00.springcloud.provider.mapper.TTopicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/5/22 2:25 PM
 */
@Service
public class TTopicService {

    @Resource
    private TTopicMapper tTopicMapper;

    long start = System.currentTimeMillis();

    @DS("sharding")
    public void add() {
        TTopic topic = new TTopic();
        topic.setTopic("topic_" + start);
        topic.setId(start++);
        topic.setState(1);
        topic.setConnect(1);
        topic.setIsPrintLog(true);
        tTopicMapper.insert(topic);
    }

    public List<TTopic> getOne() {
        return tTopicMapper.selectList(null);
    }

}
