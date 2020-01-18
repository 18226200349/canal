package com.dc.canal.elasticsearch.entity.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @ClassName EsBlog
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/184:05 下午
 **/
@Data
@Document(indexName = "blog" ,type="doc",useServerConfiguration = true,createIndex = false)
public class EsBlog {
     @Id
    private Integer id;
     @Field(type= FieldType.Text,analyzer = "ik_max_word")
    private String title;
    @Field(type= FieldType.Text,analyzer = "ik_max_word")
    private String author;
    @Field(type= FieldType.Text,analyzer = "ik_max_word")
    private String content;
    @Field(type= FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Field(type= FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
