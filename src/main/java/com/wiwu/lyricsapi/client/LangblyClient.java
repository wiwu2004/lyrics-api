package com.wiwu.lyricsapi.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class LangblyClient {

    private final WebClient webClient;

    public LangblyClient(
            WebClient.Builder builder,
            @Value("${langbly.api.key}") String apiKey
    ) {
        this.webClient = builder
                .baseUrl("https://api.langbly.com/language/translate/v2")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public Mono<String> translate(String text, String source, String target) {
        return webClient.post()
                .bodyValue(Map.of(
                        "q", text,
                        "source", source,
                        "target", target,
                        "format", "text"
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    if (response == null) {
                        return text + "(sem respostas)";
                    }

                    Map data = (Map) response.get("data");
                    if (data == null) {
                        return text + "(sem data)";
                    }

                    var translations = (List<Map>) data.get("translations");
                    if (translations == null || translations.isEmpty()) {
                        return text + "(sem traduções)";
                    }

                    return translations.get(0).get("translatedText").toString();
                })
                .onErrorReturn(text + "(erro ao traduzir)");
    }
}