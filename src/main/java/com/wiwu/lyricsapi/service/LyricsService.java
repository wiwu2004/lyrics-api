package com.wiwu.lyricsapi.service;

import com.wiwu.lyricsapi.dto.LyricsResponse;
import com.wiwu.lyricsapi.dto.VerseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LyricsService {


    public LyricsResponse process(String text){
        List<VerseDTO> verses = new ArrayList<>();
        String[] lines = text.split("\n");
        for (String line : lines){
            String cleaned = line.trim();

            if(!cleaned.isEmpty()){
                VerseDTO verse = new VerseDTO();
                verse.setOrigin(cleaned);
                verse.setTranslated(null);
                verse.setAudioUrl(null);
                verses.add(verse);
            }
        }
        LyricsResponse response = new LyricsResponse();
        response.setVerses(verses);
        return  response;
    }
}
