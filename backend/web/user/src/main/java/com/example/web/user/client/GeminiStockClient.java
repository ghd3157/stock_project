package com.example.web.user.client;

import java.util.Map;

public interface GeminiStockClient {
    Map<String, Object> getStockPrice(String stockCode);
}