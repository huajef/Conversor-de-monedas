package com.Api;

import java.util.Map;

public class ExchangeRate {
    private String base;
    private Map<String, Double> rates;

    public ExchangeRate(String base, Map<String, Double> rates) {
        this.base = base;
        this.rates = rates;
    }

    public double getRate(String currencyCode) {
        return rates.getOrDefault(currencyCode, 0.0);
    }

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
