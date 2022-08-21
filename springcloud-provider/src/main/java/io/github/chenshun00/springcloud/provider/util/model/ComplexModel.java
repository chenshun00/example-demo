package io.github.chenshun00.springcloud.provider.util.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/13 9:28 AM
 */
@Data
public class ComplexModel {

    /**
     * 目标名称
     * @default 测试
     */
    @JsonProperty("target_name")
    private String targetName;

    /**
     * 年龄
     */
    @JsonProperty("age")
    private Integer age;

    /**
     * 生日
     */
    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date birthday;

    /**
     * 标签详细列表
     */
    @JsonProperty("tag_detail_list")
    private List<TagDetail> tagDetailList;

    /**
     * 总计
     */
    @JsonProperty("total")
    private Long total;

    /**
     * 编辑详细信息
     */
    @JsonProperty("edit_detail")
    private EditDetail editDetail;

    @Data
    public static class EditDetail {
        /**
         * 用户id
         */
        @JsonProperty("user_id")
        private Long userId;
        /**
         * 内容
         */
        @JsonProperty("content")
        private String content;
        /**
         * 编辑时间
         */
        @JsonProperty("edit_time")
        private LocalDateTime editTime;
    }

    @Data
    public static class TagDetail {
        /**
         * 标签id
         */
        @JsonProperty("tag_id")
        private Long tagId;
        /**
         * 名字
         */
        @JsonProperty("name")
        private String name;
        /**
         * 颜色
         */
        @JsonProperty("color")
        private String color;
    }

}
