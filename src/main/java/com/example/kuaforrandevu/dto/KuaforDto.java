package com.example.kuaforrandevu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KuaforDto {
    private long id;
    private String kuaforSalonAd;

    private String isim;
    private  String soyisim;
    private String sifre;

    private  String eposta;
}
