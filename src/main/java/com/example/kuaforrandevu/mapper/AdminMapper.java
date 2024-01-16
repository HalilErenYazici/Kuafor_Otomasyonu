package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.dto.RandevuDto;
import com.example.kuaforrandevu.entity.Admin;
import com.example.kuaforrandevu.entity.Musteri;


public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
                admin.getId(),
                admin.getAdsoyad(),
                admin.getSifre(),
                admin.getEmail()
        );

    }
    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getId(),
                adminDto.getAdsoyad(),
                adminDto.getSifre(),
                adminDto.getEmail()

        );
    }
}
