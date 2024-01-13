package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.BizeUlas;
import com.example.kuaforrandevu.entity.Kuafor;

public class BizeUlasMapper {
    public static BizeUlasDto mapToBizeUlasDto(BizeUlas bizeUlas){
        return new BizeUlasDto(
                bizeUlas.getId(),
                bizeUlas.getAdsoyad(),
                bizeUlas.getEmail(),
                bizeUlas.getTelefon(),
                bizeUlas.getAdres(),
                bizeUlas.getMesaj()


        );
    }
    public static BizeUlas mapToBizeUlas(BizeUlasDto bizeUlasDto){
        return new BizeUlas(
                bizeUlasDto.getId(),

                bizeUlasDto.getAdsoyad(),
                bizeUlasDto.getEmail(),
                bizeUlasDto.getTelefon(),
                bizeUlasDto.getAdres(),

                bizeUlasDto.getMesaj()
        );
    }
}
