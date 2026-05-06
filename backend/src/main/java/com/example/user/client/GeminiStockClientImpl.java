package com.example.web.user.client;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GeminiStockClientImpl implements GeminiStockClient {

    @Override
    public Map<String, Object> getStockPrice(String stockCode) {
        // 이것은 모의(Mock) 구현입니다.
        // 실제 애플리케이션에서는 여기에서 제미나이 API를 호출합니다.
        return Map.of("price", 80000, "change", 1200);
    }
}