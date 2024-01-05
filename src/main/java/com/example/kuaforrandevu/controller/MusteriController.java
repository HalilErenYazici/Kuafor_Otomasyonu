package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/musteriler")
public class MusteriController {
    private MusteriService musteriService;
    public ResponseEntity<MusteriDto> musteriYarat(@RequestBody MusteriDto musteriDto){
        MusteriDto kayitEdilmisMusteri=musteriService.musteriYarat(musteriDto);
        return new ResponseEntity<>(kayitEdilmisMusteri, HttpStatus.CREATED);
    }
}
