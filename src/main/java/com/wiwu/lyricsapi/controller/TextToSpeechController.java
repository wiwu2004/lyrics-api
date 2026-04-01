package com.wiwu.lyricsapi.controller;

import com.wiwu.lyricsapi.client.TextToSpeechClient;
import com.wiwu.lyricsapi.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/tts")
public class TextToSpeechController {

    @Autowired
    private TextToSpeechClient textToSpeechClient;

    public  TextToSpeechController(TextToSpeechClient textToSpeechClient){
        this.textToSpeechClient = textToSpeechClient;
    }


    @GetMapping("/audio")
    public Mono<ResponseEntity<byte[]>> generateAudio(
            @RequestParam String text,
            @RequestParam(defaultValue = "en")Language lang
            ) {
        return textToSpeechClient.generateAudio(text, lang)
                .map(audio ->
                        ResponseEntity.ok()
                                .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg")
                                .body(audio)
                );
    }


}
