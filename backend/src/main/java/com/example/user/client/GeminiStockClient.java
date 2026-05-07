package com.example.user.client;

import java.util.Map;

public interface GeminiStockClient {
    Map<String, Object> getStockPrice(String stockCode);
}