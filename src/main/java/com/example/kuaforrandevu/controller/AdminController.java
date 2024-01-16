package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.dto.RandevuDto;
import com.example.kuaforrandevu.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;
    @PostMapping()//ne zaman çagırılıcağını bilmesi lazım
    public ResponseEntity<AdminDto> adminYarat(@RequestBody AdminDto adminDto){//post olduğu request body den gelicek
        AdminDto kayitEdilmisAdmin=adminService.adminYarat(adminDto);
        return new ResponseEntity<>(kayitEdilmisAdmin, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    //personel getirme işlemi
    public ResponseEntity<AdminDto> idIleGetir(@PathVariable("id") Long adminId){
        AdminDto adminDto=adminService.idIleGetir(adminId);
        return ResponseEntity.ok(adminDto);
    }
    @GetMapping
    public ResponseEntity<List<AdminDto>>tumAdminleriGetir(){
        List<AdminDto> adminDtoList=adminService.tumAdminleriGetir();
        return ResponseEntity.ok(adminDtoList);
    }
    //personel güncelleme işlemi
    @PutMapping("{id}")
    public ResponseEntity<AdminDto> adminGuncelle(@PathVariable("id") Long adminId,
                                                    @RequestBody AdminDto guncelAdminDto){
        AdminDto adminDto=adminService.adminGuncelle(adminId,guncelAdminDto);
        return ResponseEntity.ok(adminDto);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> adminSil(@PathVariable("id") Long adminId){
        adminService.adminSil(adminId);
        return ResponseEntity.ok("admin basarıyla silindi");
    }
}
