package com.example.tz.services;


import com.example.tz.dao.repos.CurrencyRepository;
import lombok.RequiredArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Value("${web.kztLink}")
    private String kztLink;

    @Value("${web.rubLink}")
    private String rubLink;

    private Double getCurrency(String link) {
        Double curr = 0.0;
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            StringBuilder inline = new StringBuilder();
            if (connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();
            }
            connection.disconnect();
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(inline.toString());
            JSONArray jsonArray = (JSONArray) data.get("values");
            JSONObject last = (JSONObject) jsonArray.get(0);
            curr = Double.valueOf(last.get("close").toString());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return curr;
    }


    @Scheduled(cron = "${cron.currencySet}")
    @Transactional
    public void setCurrency() {
        currencyRepository.setCurrency("KZT", getCurrency(kztLink));
        currencyRepository.setCurrency("RUB", getCurrency(rubLink));
    }
}
