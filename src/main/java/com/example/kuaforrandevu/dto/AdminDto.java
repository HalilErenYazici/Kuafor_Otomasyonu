package com.example.kuaforrandevu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Long adminId;
    private String adminAd;
    private String adminSoyad;
    private String adminSifre;
    private String kullaniciAdi;
    private String adminMail;

}
