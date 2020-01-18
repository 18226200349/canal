package com.dc.canal.elasticsearch.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/1711:30 下午
 **/
@Data
@Table(name = "t_blog")
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private Date createTime;
    private Date updateTime;
}
