package com.wiwu.lyricsapi.client;
import com.wiwu.lyricsapi.enums.Language;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
    public class TextToSpeechClient {

        private final WebClient webClient;

        public TextToSpeechClient(WebClient.Builder builder) {
            this.webClient = builder
                    .baseUrl("https://translate.google.com")
                    .defaultHeader(
                            "User-Agent",
                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
                    )
                    .build();
        }

        public Mono<byte[]> generateAudio(String text, Language lang) {
            return webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/translate_tts")
                            .queryParam("q", text)
                            .queryParam("tl", lang.getTtsCode())
                            .queryParam("client", "tw-ob")
                            .build()
                    )
                    .retrieve()
                    .bodyToMono(byte[].class);
        }
    }
