package com.pushka.alfatask.service;

public interface RatesService {
    void getLatestCurrencyRates(String currency);

    void getYesterdayCurrencyRates(String currency);

    int compareCurrencyRates(String currency) throws Exception;

    boolean getCurrencies();
}
