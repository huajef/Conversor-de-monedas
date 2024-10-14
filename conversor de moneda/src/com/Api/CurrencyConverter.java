package com.Api;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public ExchangeRate fetchExchangeRates(String baseCurrency) throws Exception {
        String urlString = API_URL + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        Gson gson = new Gson();
        return gson.fromJson(reader, ExchangeRate.class);
    }

    public double convert(double amount, String fromCurrency, String toCurrency) throws Exception {
        ExchangeRate rates = fetchExchangeRates(fromCurrency);
        double rate = rates.getRate(toCurrency);
        return amount * rate;
    }
}
