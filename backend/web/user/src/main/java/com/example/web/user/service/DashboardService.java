package com.example.web.user.service;

import com.example.web.user.client.GeminiStockClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final GeminiStockClient geminiStockClient;

    public DashboardService(GeminiStockClient geminiStockClient) {
        this.geminiStockClient = geminiStockClient;
    }

    @Cacheable(value = "dashboardData", key = "'getDashboardData'")
    public List<Map<String, Object>> getDashboardData() {
        // 실제 애플리케이션에서는 데이터베이스에서 사용자 포트폴리오를 가져온 후
        // GeminiStockClient를 통해 실시간 주식 가격을 가져옵니다.
        // 현재는 모의(Mock) 데이터를 반환합니다.
        return List.of(
                Map.of("stockName", "Samsung Electronics", "currentPrice", 80000, "changeRate", 0.015),
                Map.of("stockName", "SK Hynix", "currentPrice", 130000, "changeRate", -0.02)
        );
    }
}