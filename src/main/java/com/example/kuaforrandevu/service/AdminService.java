package com.example.kuaforrandevu.service;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.dto.KuaforDto;

import java.util.List;


public interface AdminService {
    AdminDto adminYarat(AdminDto adminDto);
    AdminDto idIleGetir(Long adminId);
    List<AdminDto> tumAdminleriGetir();
    AdminDto adminGuncelle(Long adminId, AdminDto guncellenenAdmin);
    void adminSil(Long adminId);

}
