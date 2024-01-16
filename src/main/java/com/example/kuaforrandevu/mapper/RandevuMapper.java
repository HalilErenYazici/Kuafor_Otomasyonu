package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.dto.RandevuDto;
import com.example.kuaforrandevu.entity.Musteri;
import com.example.kuaforrandevu.entity.Randevu;

public class RandevuMapper  {

    public static RandevuDto mapToRandevuDto(Randevu randevu){
        return new RandevuDto(
                randevu.getId(),
                randevu.getMusteriisim(),
                randevu.getKuaforAd(),
                randevu.getIslem(),
                randevu.getGun(),
                randevu.getSaat(),
                randevu.getOnay()
        );

    }
    public static Randevu mapToRandevu(RandevuDto randevuDto){
        return new Randevu(
                randevuDto.getId(),
                randevuDto.getMusteriisim(),
                randevuDto.getKuaforAd(),

                randevuDto.getIslem(),
                randevuDto.getGun(),
                randevuDto.getSaat(),
                randevuDto.getOnay()


        );

    }
}