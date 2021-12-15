package com.petrova.FX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientParseData {


    public String getDataAboutAnimeCharacter(String beginUrl) {

        try {
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
                return parseAnimeJson(content).toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Anime parseAnimeJson(StringBuilder content) {

        String s = content.toString();
        String anime = s.substring(s.indexOf("anime") + 8, s.indexOf("character") - 3);
        String character = s.substring(s.indexOf("character") + 12, s.indexOf("quote") - 3);
        String quote = s.substring(s.indexOf("quote") + 8, s.length() - 3);
        return new Anime(anime, character, quote);
    }
}

