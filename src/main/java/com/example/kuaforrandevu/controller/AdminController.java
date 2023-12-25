package com.example.kuaforrandevu.controller;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adminler")
public class AdminController {
    private AdminService adminService;
    @PostMapping()//ne zaman çagırılıcağını bilmesi lazım
    public ResponseEntity<AdminDto> adminYarat(@RequestBody AdminDto adminDto){//post olduğu request body den gelicek
        AdminDto kayitEdilmisAdmin=adminService.adminYarat(adminDto);
        return new ResponseEntity<>(kayitEdilmisAdmin, HttpStatus.CREATED);
    }
}
