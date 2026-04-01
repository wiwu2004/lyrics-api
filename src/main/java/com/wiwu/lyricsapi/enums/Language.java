package com.wiwu.lyricsapi.enums;

public enum Language {

    EN("EN"),
    ES("ES"),
    PT("PT");

    private final String ttsCode;

    Language(String ttsCode) {
        this.ttsCode = ttsCode;
    }

    public String getTtsCode() {
        return ttsCode;
    }
}
