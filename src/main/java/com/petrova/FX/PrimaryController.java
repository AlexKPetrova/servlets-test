package com.petrova.FX;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.MalformedURLException;

public class PrimaryController {

    @FXML
    private TextField busInput;

    @FXML
    private Text text;

    //извиите, но автобусы нифига не грузят, а это была первая апишка, которую я нашла и в которой
    //не требовалась регистрация
    private final String animeAPI = "https://animechan.vercel.app/api/random";

    @FXML
    void getAnimeCharacter(ActionEvent event) throws MalformedURLException {
        HttpClientParseData httpClientParseData = new HttpClientParseData();
        text.setText(httpClientParseData.getDataAboutAnimeCharacter(animeAPI));
    }
}
