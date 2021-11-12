package com.example.checkpoint_9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ExchangeRestController {
    Exchange exchange;

    public ExchangeRestController(RestTemplate restTemplate){
        this.exchange = restTemplate.getForObject("https://awcheckpoint.blob.core.windows.net/stuff/rates.json", Exchange.class);
    }

    @GetMapping("/convert")
    public Currency getExchangeRates(
            @RequestParam int amount,
            @RequestParam String currency
    ){
        if (exchange!=null){
            Map<String, Double> rates = exchange.getRates();
            return new Currency(amount*rates.get(currency), currency, amount);
        }
        return null;
    }

}
