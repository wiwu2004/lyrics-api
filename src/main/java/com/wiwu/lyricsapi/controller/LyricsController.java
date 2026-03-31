package com.wiwu.lyricsapi.controller;

import com.wiwu.lyricsapi.dto.LyricsRequest;
import com.wiwu.lyricsapi.dto.LyricsResponse;
import com.wiwu.lyricsapi.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lyrics")
public class LyricsController {


    @Autowired
    private LyricsService service;

    @RequestMapping("/process")
    public ResponseEntity<LyricsResponse> process(@RequestBody LyricsRequest request){
        LyricsResponse response = service.process(request.getText());
        return ResponseEntity.ok(response);
    }
}
