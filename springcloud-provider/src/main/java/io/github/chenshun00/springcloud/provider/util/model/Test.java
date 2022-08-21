package io.github.chenshun00.springcloud.provider.util.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/13 8:53 PM
 */
@NoArgsConstructor
@Data
public class Test {


    @JsonProperty("target_name")
    private String targetName;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("tag_detail_list")
    private List<TagDetailListDTO> tagDetailList;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("edit_detail")
    private EditDetailDTO editDetail;

    @NoArgsConstructor
    @Data
    public static class EditDetailDTO {
        @JsonProperty("user_id")
        private Integer userId;
        @JsonProperty("content")
        private String content;
        @JsonProperty("edit_time")
        private String editTime;
    }

    @NoArgsConstructor
    @Data
    public static class TagDetailListDTO {
        @JsonProperty("tag_id")
        private Integer tagId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("color")
        private String color;
    }
}
