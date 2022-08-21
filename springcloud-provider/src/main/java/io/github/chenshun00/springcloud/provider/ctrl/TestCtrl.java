package io.github.chenshun00.springcloud.provider.ctrl;

import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.provider.config.RefreshConfig;
import io.github.chenshun00.springcloud.provider.service.TTopicService;
import io.github.chenshun00.springcloud.provider.util.model.ComplexModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.olegcherednik.jackson.utils.JacksonUtils;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author chenshun00@gmail.com
 * @since 2022/4/26 10:00 PM
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestCtrl {

    @Resource
    private TTopicService tTopicService;
    @Resource
    private RefreshConfig refreshConfig;

    /**
     * post请求
     *
     * @param complexModel 复杂模型
     * @return {@link ComplexModel}
     */
    @PostMapping("postRequest")
    public ComplexModel postRequest(@RequestBody ComplexModel complexModel) {
        log.info("json: {}", JacksonUtils.writeValue(complexModel));
        return complexModel;
    }

    @GetMapping("one")
    public Book one(ComplexModel complexModel) {
        log.info("「refreshConfig:{}」", complexModel);
        return new Book();
    }

    @PostMapping("{type}/add")
    public Book pr(@PathVariable String type) {
        log.info("[add any type]");
        return new Book();
    }

    @PostMapping("project/add")
    public Book project() {
        log.info("[add project]");
        return new Book();
    }

}
