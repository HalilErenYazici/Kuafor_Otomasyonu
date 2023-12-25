package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuaforler")
public class KuaforController {

    private KuaforService kuaforService;
    @PostMapping()//ne zaman çagırılıcağını bilmesi lazım
    public ResponseEntity<KuaforDto> kuaforYarat(@RequestBody KuaforDto kuaforDto){//post olduğu request body den gelicek
        KuaforDto kayitEdilmisPersonel=kuaforService.kuaforYarat(kuaforDto);
        return new ResponseEntity<>(kayitEdilmisPersonel, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    //personel getirme işlemi
    public ResponseEntity<KuaforDto> idIleGetir(@PathVariable("id") Long kuaforId){
        KuaforDto kuaforDto=kuaforService.idIleGetir(kuaforId);
        return ResponseEntity.ok(kuaforDto);
    }
    //tüm personelleri getirme işlemi
    @GetMapping
    public ResponseEntity<List<KuaforDto>>tumKuaforleriGetir(){
        List<KuaforDto> kuaforDtoList=kuaforService.tumPersonelleriGetir();
        return ResponseEntity.ok(kuaforDtoList);
    }

    //personel güncelleme işlemi
    @PutMapping("{id}")
    public ResponseEntity<KuaforDto> kuaforGuncelle(@PathVariable("id") Long kuaforId,
                                                    @RequestBody KuaforDto guncelKuaforDto){
        KuaforDto kuaforDto=kuaforService.kuaforGuncelle(kuaforId,guncelKuaforDto);
        return ResponseEntity.ok(kuaforDto);


    }

    //kuafor silme
    @DeleteMapping("{id}")
    public  ResponseEntity<String> kuaforSil(@PathVariable("id") Long kuaforId){
        kuaforService.kuaforSil(kuaforId);
        return  ResponseEntity.ok("Personel başarıyla silindi");
    }
}
