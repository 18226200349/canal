package com.dc.canal.elasticsearch.contoller;

import com.dc.canal.elasticsearch.dao.es.EsBlogDao;
import com.dc.canal.elasticsearch.dao.mysql.BlogDao;
import com.dc.canal.elasticsearch.entity.es.EsBlog;
import com.dc.canal.elasticsearch.entity.mysql.Blog;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName DataController
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/189:53 下午
 **/
@RestController
public class DataController {
    @Autowired
    private EsBlogDao esBlogDao;
    @Autowired
    private BlogDao blogDao;
    @GetMapping("/blogs")
    public Object blog(){
        List<Blog> blogs = blogDao.queryAll();
        return blogs;
    }
    @PostMapping("/search")
    public Object search(@RequestBody Param param){
        HashMap<String,Object> map=new HashMap<>();
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
     String type=param.getType();
     if(type.equalsIgnoreCase("mysql")){
         List<Blog> blogs = blogDao.queryBlogs(param.getKeyword());
         map.put("list",blogs);
     }else if(type.equalsIgnoreCase("es")){
         BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
         boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title",param.getKeyword()));
         boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content",param.getKeyword()));
         Page<EsBlog> search =(Page<EsBlog>) esBlogDao.search(boolQueryBuilder);
         List<EsBlog> esBlogs=search.getContent();
         map.put("list",esBlogs);
     }
     stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        map.put("duration",totalTimeMillis);
        return  map;
    }
    @Data
    public  static  class  Param {
        private String type;
        private String keyword;
    }
}
