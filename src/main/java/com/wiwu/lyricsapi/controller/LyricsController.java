package com.wiwu.lyricsapi.controller;

import com.wiwu.lyricsapi.dto.LyricsRequest;
import com.wiwu.lyricsapi.dto.LyricsResponse;
import com.wiwu.lyricsapi.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lyrics")
public class LyricsController {

    @Autowired
    private LyricsService service;

    @PostMapping("/process")
    public Mono<ResponseEntity<LyricsResponse>> process(@RequestBody LyricsRequest request) {
        return service.process(request.getText())
                .map(ResponseEntity::ok);
    }
}