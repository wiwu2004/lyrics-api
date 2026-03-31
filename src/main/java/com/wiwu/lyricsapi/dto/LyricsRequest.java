package com.wiwu.lyricsapi.dto;


import java.util.Objects;

public class LyricsRequest {
    private String text;
    private String sourceLang;
    private String targetLang;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LyricsRequest that)) return false;
        return Objects.equals(getText(), that.getText()) && Objects.equals(getSourceLang(), that.getSourceLang()) && Objects.equals(getTargetLang(), that.getTargetLang());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText(), getSourceLang(), getTargetLang());
    }
}
