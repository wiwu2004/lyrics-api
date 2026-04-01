package com.wiwu.lyricsapi.service;

import com.wiwu.lyricsapi.client.LangblyClient;
import com.wiwu.lyricsapi.dto.LyricsResponse;
import com.wiwu.lyricsapi.dto.VerseResponse;
import com.wiwu.lyricsapi.enums.Language;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Service
public class LyricsService {

    private final LangblyClient langblyClient;

    public LyricsService(LangblyClient langblyClient) {
        this.langblyClient = langblyClient;
    }

    public Mono<LyricsResponse> process(
            String text,
            Language source,
            Language target
    ) {

        return Flux.fromArray(text.split("\n"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> translateVerse(line, source, target))
                .collectList()
                .map(verses -> {
                    LyricsResponse response = new LyricsResponse();
                    response.setVerses(verses);
                    return response;
                });
    }

    private VerseResponse translateVerse(
            String line,
            Language source,
            Language target
    ) {
        String translated = langblyClient
                .translate(
                        line,
                        source.getTtsCode(),
                        target.getTtsCode()
                )
                .block();

        VerseResponse verse = new VerseResponse();
        verse.setOrigin(line);
        verse.setTranslated(translated);
        verse.setAudioUrl(
                "/tts/audio?text="
                        + UriUtils.encode(line, StandardCharsets.UTF_8)
                        + "&lang="
                        + source.getTtsCode()
        );

        return verse;
    }
}