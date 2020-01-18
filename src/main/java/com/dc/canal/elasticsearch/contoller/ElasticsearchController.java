package com.dc.canal.elasticsearch.contoller;

import com.dc.canal.elasticsearch.dao.mysql.BlogDao;
import com.dc.canal.elasticsearch.entity.mysql.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ElasticsearchContrller
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/1711:34 下午
 **/
@Controller
public class ElasticsearchController {
    @Resource
   private BlogDao blogDao;
    @RequestMapping("/")
    public String index(){
       List<Blog> blogList=blogDao.findAll();
        System.out.println(blogList.size());
        return "index.html";
    }
}
