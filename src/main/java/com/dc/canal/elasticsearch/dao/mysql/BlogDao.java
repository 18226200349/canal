package com.dc.canal.elasticsearch.dao.mysql;

import com.dc.canal.elasticsearch.entity.mysql.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName BlogDao
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/1711:57 下午
 **/
@Repository
public interface BlogDao extends JpaRepository<Blog,Integer> {
    @Query("select  e from Blog e order by  e.createTime desc ")
    List<Blog> queryAll();
    @Query("select  e from Blog e where e.title " +
            " like concat('%',:keyword,'%') or e.content like concat('%',:keyword,'%')")
    List<Blog> queryBlogs(@Param("keyword") String keyword);
}
