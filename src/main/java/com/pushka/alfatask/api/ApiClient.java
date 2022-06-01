package com.pushka.alfatask.api;

import com.pushka.alfatask.dto.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "currencies-api", url = "${urlExchange}")
public interface ApiClient {
    @GetMapping("/latest.json")
    Currency getLatestRates(@RequestParam("app_id") String app_id, @RequestParam("symbols") String currency);

    @GetMapping("historical/{date}.json")
    Currency getYesterdayRates(@PathVariable String date, @RequestParam("app_id") String app_id, @RequestParam("symbols") String symbols);

    @GetMapping("/currencies.json")
    Map<String, String> getCurrencies();
}
