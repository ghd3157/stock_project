package com.example.user.service;

import com.example.common.jpa.Portfolio;
import com.example.common.jpa.User;
import com.example.user.client.GeminiStockClient;
import com.example.user.repository.PortfolioRepository;
import com.example.user.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final GeminiStockClient geminiStockClient;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public DashboardService(GeminiStockClient geminiStockClient, PortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.geminiStockClient = geminiStockClient;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Cacheable(value = "dashboardData", key = "#username")
    public List<Map<String, Object>> getDashboardData(String username) {
        // 1. Find User object by username
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // 2. Get the portfolio list for the user
        List<Portfolio> portfolios = portfolioRepository.findByUserId(user.getId());

        // 3. Create dashboard data with real-time price information while iterating through the portfolio list
        return portfolios.stream().map(portfolio -> {
            // Real-time price inquiry with Gemini client (currently Mock)
            Map<String, Object> stockPriceInfo = geminiStockClient.getStockPrice(portfolio.getStockCode());

            double currentPrice = (double) stockPriceInfo.getOrDefault("price", 0.0);
            double averagePrice = portfolio.getAveragePrice();
            double changeRate = (averagePrice == 0) ? 0 : (currentPrice - averagePrice) / averagePrice;

            Map<String, Object> stockData = new HashMap<>();
            stockData.put("stockName", portfolio.getStockCode()); // In reality, you need to find the stock name by its code
            stockData.put("currentPrice", currentPrice);
            stockData.put("changeRate", changeRate);
            stockData.put("quantity", portfolio.getQuantity());
            stockData.put("averagePrice", averagePrice);
            return stockData;
        }).collect(Collectors.toList());
    }
}
