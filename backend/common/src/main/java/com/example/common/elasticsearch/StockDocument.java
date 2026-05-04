package com.example.common.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "stocks")
public class StockDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "korean")
    private String stockName;

    public StockDocument(String id, String stockName) {
        this.id = id;
        this.stockName = stockName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}