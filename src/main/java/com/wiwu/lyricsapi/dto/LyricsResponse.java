package com.wiwu.lyricsapi.dto;

import java.util.List;
import java.util.Objects;

public class LyricsResponse {

    private List<VerseDTO> verses;

    public List<VerseDTO> getVerses() {
        return verses;
    }

    public void setVerses(List<VerseDTO> verses) {
        this.verses = verses;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LyricsResponse that)) return false;
        return Objects.equals(getVerses(), that.getVerses());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getVerses());
    }
}
