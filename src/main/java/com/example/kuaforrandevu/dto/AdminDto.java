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
    private long adminId;

    private String adminSifre;
    private String kullaniciAdi;
    private String adminMail;

}
