package com.petrova.servlet;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpClientParsData {

    public String getDataAboutBus(String garagNumb) {

        String  beginUrl = "http://data.kzn.ru:8082/api/v0/dynamic_datasets/bus/" + garagNumb + ".json";

        try {

            //http://data.kzn.ru:8082/api/v0/dynamic_datasets/bus.json
            URL url = new URL(beginUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )) {
                StringBuilder content = new StringBuilder();
                String input;

                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                connection.disconnect();
                return content.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
