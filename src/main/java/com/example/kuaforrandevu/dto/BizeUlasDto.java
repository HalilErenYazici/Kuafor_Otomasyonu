package com.example.kuaforrandevu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BizeUlasDto {
    private long id ;
    private String adsoyad;
    private String email;
    private String telefon;
    private String adres;
    private String mesaj;
}
