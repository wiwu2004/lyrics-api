package com.wiwu.lyricsapi.service;

import com.wiwu.lyricsapi.client.LangblyClient;
import com.wiwu.lyricsapi.dto.LyricsResponse;
import com.wiwu.lyricsapi.dto.VerseResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LyricsService {

    private final LangblyClient langblyClient;

    public LyricsService(LangblyClient langblyClient) {
        this.langblyClient = langblyClient;
    }

    public Mono<LyricsResponse> process(String text) {

        return Flux.fromArray(text.split("\n"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .flatMapSequential(this::translateVerse)
                .collectList()
                .map(verses -> {
                    LyricsResponse response = new LyricsResponse();
                    response.setVerses(verses);
                    return response;
                });
    }

    private Mono<VerseResponse> translateVerse(String line) {

        return langblyClient.translate(line, "en", "pt")
                .map(translated -> {
                    VerseResponse verse = new VerseResponse();
                    verse.setOrigin(line);
                    verse.setTranslated(translated);
                    verse.setAudioUrl(null);
                    return verse;
                });
    }
}