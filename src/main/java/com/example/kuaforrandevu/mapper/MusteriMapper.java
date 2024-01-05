package com.example.kuaforrandevu.mapper;


import com.example.kuaforrandevu.dto.MusteriDto;

import com.example.kuaforrandevu.entity.Musteri;
import jakarta.persistence.Column;

public class MusteriMapper {
    public static MusteriDto mapToMusteriDto(Musteri musteri){
        return new MusteriDto(
                musteri.getId(),
                musteri.getMusteriisim(),
                musteri.getMusterisoyisim(),
                musteri.getMusterisifre(),
                musteri.getEposta()

                );
    }
    public static Musteri mapToMusteri(MusteriDto musteriDto){
        return new Musteri(
                musteriDto.getId(),
                musteriDto.getMusteriisim(),

                musteriDto.getMusterisoyisim(),
                musteriDto.getMusterisifre(),
                musteriDto.getEposta()

        );
    }


}
