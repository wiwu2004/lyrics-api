package com.wiwu.lyricsapi.dto;

import java.util.Objects;

public class VerseDTO {
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
        if (!(o instanceof VerseDTO verseDTO)) return false;
        return Objects.equals(getOrigin(), verseDTO.getOrigin()) && Objects.equals(getTranslated(), verseDTO.getTranslated()) && Objects.equals(getAudioUrl(), verseDTO.getAudioUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getTranslated(), getAudioUrl());
    }
}

