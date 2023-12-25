package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.KuaforRandevuApplication;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.Kuafor;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor){
        return new KuaforDto(
                kuafor.getId(),
                kuafor.getKuaforSalonAd(),
                kuafor.getIsim(),
                kuafor.getSoyisim(),
                kuafor.getSifre(),
                kuafor.getEposta()
        );
    }
    public static Kuafor mapToKuafor(KuaforDto kuaforDto){
        return new Kuafor(
                kuaforDto.getId(),
                kuaforDto.getKuaforSalonAd(),

                kuaforDto.getIsim(),
                kuaforDto.getSoyisim(),
                kuaforDto.getSifre(),

                kuaforDto.getEposta()
        );
    }
}
