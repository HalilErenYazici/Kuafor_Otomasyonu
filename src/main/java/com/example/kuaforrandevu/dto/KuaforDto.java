package com.example.kuaforrandevu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class KuaforDto {
    private long id;

    private String isim;
    private  String soyisim;
    private String sifre;

    private  String eposta;
}
