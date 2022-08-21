package io.github.chenshun00.springcloud.provider.util;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.chenshun00.springcloud.api.Book;
import io.github.chenshun00.springcloud.provider.util.model.ComplexModel;
import ru.olegcherednik.jackson.utils.JacksonUtils;
import ru.olegcherednik.jackson.utils.JacksonUtilsHelper;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author chenshun00@gmail.com
 * @since 2022/8/13 9:14 AM
 */
public class JsonTest {

    /**
     * <ul>
     *     使用fastjson的几个场景
     *     <li>
     *          对象反序列化，用 {@link com.alibaba.fastjson.JSONObject#parseObject(String)} 序列化对象 以及
     *          {@link com.alibaba.fastjson.JSONObject#parseArray(String)}  序列化数组类型
     *     </li>
     *     <li>
     *          使用{@link  com.alibaba.fastjson.JSONObject} 获取内部的JSON对象 {@link  com.alibaba.fastjson.JSONObject#getJSONObject(String)}
     *     </li>
     *     <li>
     *         对象序列化成json
     *     </li>
     * </ul>
     * <p>
     * 替换的场景起码也要能解决这两个才行
     */
    public static void main(String[] args) throws IOException {
        eval();
    }

    private static void eval() throws IOException {
        var inf = """
                                {
                                  "target_name": "test_35a6e9f641a5",
                                  "age": 42,
                                  "birthday": "2021-09-09 15:35:27",
                                  "tag_detail_list": [
                                    {
                                      "tag_id": 15,
                                      "name": "test_aec5afe3408e",
                                      "color": "test_a2f44e8093db"
                                    }
                                  ],
                                  "total": 32,
                                  "edit_detail": {
                                    "user_id": 28,
                                    "content": "test_02a3e2593b3d",
                                    "edit_time": "2023-02-20 09:04:40"
                                  }
                                }
                """;
        final JsonNode jsonNode = JacksonUtilsHelper.createMapper().readValue(inf, JsonNode.class);


        System.out.println(jsonNode.at("/target_name").asText());
        System.out.println(jsonNode.at("/tag_detail_list/0/name"));
    }

    private static void parseArray() {
        var inf = """
                [
                {
                  "target_name": "test_c6a01758166b",
                  "age": 81,
                  "birthday": "2019-07-08 07:08:56",
                  "tag_detail_list": [
                    {
                      "tag_id": 69,
                      "name": "test_3b26b2d188c4",
                      "color": "test_b427ca7be9a8"
                    }
                  ],
                  "total": 97
                },
                {
                  "target_name": "test_c6a01758166b",
                  "age": 81,
                  "birthday": "2019-07-08 07:08:56",
                  "tag_detail_list": [
                    {
                      "tag_id": 69,
                      "name": "test_3b26b2d188c4",
                      "color": "test_b427ca7be9a8"
                    }
                  ],
                  "total": 97
                },
                {
                  "target_name": "test_c6a01758166b",
                  "age": 81,
                  "birthday": "2019-07-08 07:08:56",
                  "tag_detail_list": [
                    {
                      "tag_id": 69,
                      "name": "test_3b26b2d188c4",
                      "color": "test_b427ca7be9a8"
                    }
                  ],
                  "total": 97
                }
                ]
                """;
        final List<ComplexModel> complexModels = JacksonUtils.readList(inf, ComplexModel.class);
        System.out.println(JacksonUtils.writeValue(complexModels));
    }

    private static void parseObject() {
        var inf = """
                {
                  "target_name": "test_c6a01758166b",
                  "age": 81,
                  "birthday": "2019-07-08 07:08:56",
                  "tag_detail_list": [
                    {
                      "tag_id": 69,
                      "name": "test_3b26b2d188c4",
                      "color": "test_b427ca7be9a8"
                    }
                  ],
                  "total": 97
                }
                """;
        final ComplexModel complexModel = JacksonUtils.readValue(inf, ComplexModel.class);
        System.out.println(complexModel);
    }

    private static void toJsonString(Object obj) {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("陈顺");
        book.setPublishDate(new Date());
        book.setName("测试");

        final String s = JacksonUtils.writeValue(book);
        System.out.println(s);
    }

}
