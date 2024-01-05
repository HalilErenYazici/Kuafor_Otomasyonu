package com.example.kuaforrandevu.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MusteriDto {
    private long id ;
    private String Musteriisim;
    private String Musterisoyisim;
    private String Musterisifre;

    private String eposta;
}
