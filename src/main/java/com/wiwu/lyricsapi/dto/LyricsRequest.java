package com.wiwu.lyricsapi.dto;


import com.wiwu.lyricsapi.enums.Language;


public class LyricsRequest {
    private String text;
    private Language sourceLang;
    private Language targetLang;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Language getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(Language sourceLang) {
        this.sourceLang = sourceLang;
    }

    public Language getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(Language targetLang) {
        this.targetLang = targetLang;
    }


}
