package com.dc.canal.elasticsearch.dao.es;

import com.dc.canal.elasticsearch.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogDao extends ElasticsearchRepository<EsBlog,Integer> {
}
