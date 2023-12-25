package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.entity.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
                admin.getAdminId(),
                admin.getAdminSifre(),
                admin.getAdminAd(),
                admin.getAdminMail(),
                admin.getKullaniciAdi(),
                admin.getAdminSoyad()
        );
    }
    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getAdminId(),
                adminDto.getAdminSifre(),
                adminDto.getAdminAd(),
                adminDto.getAdminMail(),
                adminDto.getKullaniciAdi(),
                adminDto.getAdminSoyad()
        );
    }
}
