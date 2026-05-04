package com.example.common.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StockSearchRepository extends ElasticsearchRepository<StockDocument, String> {
}