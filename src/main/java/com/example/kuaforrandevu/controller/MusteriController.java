package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/musteriler")
public class MusteriController {
    private MusteriService musteriService;

    @PostMapping()
    public ResponseEntity<MusteriDto> musteriYarat(@RequestBody MusteriDto musteriDto){
        MusteriDto kayitEdilmisMusteri=musteriService.musteriYarat(musteriDto);
        return new ResponseEntity<>(kayitEdilmisMusteri, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<MusteriDto>idIleGetir(@PathVariable("id") Long musteriId){
        MusteriDto musteriDto=musteriService.idIleGetir(musteriId);
        return ResponseEntity.ok(musteriDto);
    }
    //tüm personelleri getirme işlemi
    @GetMapping
    public ResponseEntity<List<MusteriDto>>tumMusterileriGetir(){
        List<MusteriDto> musteriDtoList=musteriService.tumMusterileriGetir();
        return ResponseEntity.ok(musteriDtoList);
    }
    //personel güncelleme işlemi
    @PutMapping("{id}")
    public ResponseEntity<MusteriDto> musteriGuncelle(@PathVariable("id") Long musteriId,@RequestBody MusteriDto guncelMusteriDto){
        MusteriDto musteriDto=musteriService.musteriGuncelle(musteriId,guncelMusteriDto);
        return ResponseEntity.ok(musteriDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> musteriSil(@PathVariable("id") Long musteriId){
        musteriService.musteriSil(musteriId);
        return ResponseEntity.ok("personel basarıyla silindi");
    }

}
