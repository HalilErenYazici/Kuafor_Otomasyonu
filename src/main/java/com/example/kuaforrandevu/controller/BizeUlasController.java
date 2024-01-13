package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.service.BizeUlasService;
import com.example.kuaforrandevu.service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bizulasin")
public class BizeUlasController {

    private BizeUlasService bizeUlasService;
    @PostMapping()//ne zaman çagırılıcağını bilmesi lazım
    public ResponseEntity<BizeUlasDto> bizeUlasYarat(@RequestBody BizeUlasDto bizeUlasDto){//post olduğu request body den gelicek
        BizeUlasDto kayitEdilmisBizeUlas=bizeUlasService.bizeUlasYarat(bizeUlasDto);
        return new ResponseEntity<>(kayitEdilmisBizeUlas, HttpStatus.CREATED);
    }

    //getirme işlemi
    @GetMapping("{id}")
    //personel getirme işlemi
    public ResponseEntity<BizeUlasDto> idIleGetir(@PathVariable("id") Long bizeUlasId){
        BizeUlasDto bizeUlasDto=bizeUlasService.idIleGetir(bizeUlasId);
        return ResponseEntity.ok(bizeUlasDto);
    }
    //tüm personelleri getirme işlemi
    @GetMapping
    public ResponseEntity<List<BizeUlasDto>>tumBizeUlaslariGetir(){
        List<BizeUlasDto> bizeUlasDtoList=bizeUlasService.tumBizeUlasinlariGetir();
        return ResponseEntity.ok(bizeUlasDtoList);
    }

    //bize ulas silme
    @DeleteMapping("{id}")
    public  ResponseEntity<String> bizeUlasSil(@PathVariable("id") Long bizeUlasId){
        bizeUlasService.BizeUlasSil(bizeUlasId);
        return  ResponseEntity.ok("Personel başarıyla silindi");
    }
}
