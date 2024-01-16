package com.example.kuaforrandevu.mapper;

import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.Kuafor;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor){
        return new KuaforDto(
                kuafor.getId(),
                kuafor.getIsim(),
                kuafor.getSoyisim(),
                kuafor.getSifre(),
                kuafor.getSaat(),

                kuafor.getEposta()
        );
    }
    public static Kuafor mapToKuafor(KuaforDto kuaforDto){
        return new Kuafor(
                kuaforDto.getId(),

                kuaforDto.getIsim(),
                kuaforDto.getSoyisim(),
                kuaforDto.getSifre(),
                kuaforDto.getSaat(),
                kuaforDto.getEposta()
        );
    }



}
