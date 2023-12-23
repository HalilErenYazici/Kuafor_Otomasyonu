package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
