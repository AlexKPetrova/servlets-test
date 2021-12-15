package com.petrova.FX;

public class Anime {
    String anime;
    String character;
    String quote;

    public Anime(String anime, String character, String quote) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return
                "-_- " + anime + '\n' +
                        " " + character + '\n' +
                        " '" + quote + '\'' + ":^)";
    }
}