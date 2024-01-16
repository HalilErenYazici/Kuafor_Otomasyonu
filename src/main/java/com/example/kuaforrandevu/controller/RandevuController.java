package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.dto.RandevuDto;
import com.example.kuaforrandevu.service.MusteriService;
import com.example.kuaforrandevu.service.RandevuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevu")
public class RandevuController {
    private RandevuService randevuService;
    @PostMapping
    public ResponseEntity <RandevuDto> randevuYarat(@RequestBody RandevuDto randevuDto){
        RandevuDto kayitEdilmisRandevu=randevuService.randevuYarat(randevuDto);
        return new ResponseEntity<>(kayitEdilmisRandevu, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    //personel getirme işlemi
    public ResponseEntity<RandevuDto> idIleGetir(@PathVariable("id") Long randevuId){
        RandevuDto randevuDto=randevuService.idIleGetir(randevuId);
        return ResponseEntity.ok(randevuDto);
    }
    @GetMapping
    public ResponseEntity<List<RandevuDto>>tumRandevulariGetir(){
        List<RandevuDto> randevuDtoList=randevuService.tumRandevulariGetir();
        return ResponseEntity.ok(randevuDtoList);
    }
    @PutMapping("{id}")
    public ResponseEntity<RandevuDto> randevuGuncelle(@PathVariable("id") Long randevuId,
                                                  @RequestBody RandevuDto guncelRandevuDto){
        RandevuDto randevuDto=randevuService.randevuGuncelle(randevuId,guncelRandevuDto);
        return ResponseEntity.ok(randevuDto);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> randevuSil(@PathVariable("id") Long randevuId){
        randevuService.randevuSil(randevuId);
        return ResponseEntity.ok("randevu basarıyla silindi");
    }
}
