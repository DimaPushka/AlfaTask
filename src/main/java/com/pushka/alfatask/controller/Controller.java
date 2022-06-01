package com.pushka.alfatask.controller;

import com.pushka.alfatask.dto.GIF;
import com.pushka.alfatask.service.GifService;
import com.pushka.alfatask.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {
    @Autowired
    private RatesService exchangeRatesService;
    @Autowired
    private GifService gifService;


    @GetMapping("/gifs/{currency}")
    public String test(@PathVariable String currency, Model model) throws Exception {

        String tag = "bart";
        int compareResult = exchangeRatesService.compareCurrencyRates(currency);

        switch (compareResult){
            case 1: tag = "rich";
                break;
            case -1: tag = "broke";
                break;
            case 0: tag = "nothing";
                break;
            case 404: tag = "fatal error";
                break;
        }

        GIF gif = gifService.getGIF(tag);
        String url = gif.getData().getImages().getGifDTO().getUrl();
        model.addAttribute("myGif", url);
        return "main-view";
    }

    @RequestMapping("/get_gif/{tag}")
    public ResponseEntity<Object> getGif(@PathVariable String tag){
        return ResponseEntity.ok(gifService.getGIF(tag));
    }

}
