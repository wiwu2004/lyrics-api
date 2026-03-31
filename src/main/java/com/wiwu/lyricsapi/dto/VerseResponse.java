package com.wiwu.lyricsapi.dto;

import java.util.Objects;

public class VerseResponse {
    private String origin;
    private String translated;
    private String audioUrl;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VerseResponse verseResponse)) return false;
        return Objects.equals(getOrigin(), verseResponse.getOrigin()) && Objects.equals(getTranslated(), verseResponse.getTranslated()) && Objects.equals(getAudioUrl(), verseResponse.getAudioUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getTranslated(), getAudioUrl());
    }
}

