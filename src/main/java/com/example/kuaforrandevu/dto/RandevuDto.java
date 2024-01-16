package com.example.kuaforrandevu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RandevuDto {
    private long id ;
    private String Musteriisim;
    private String KuaforAd;

    private String islem;
    private String gun;
    private String saat;
    private String onay;
}
