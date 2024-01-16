package com.example.kuaforrandevu.service;


import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.dto.RandevuDto;

import java.util.List;

public interface RandevuService {
    RandevuDto randevuYarat(RandevuDto randevuDto);
    RandevuDto idIleGetir(Long randevuId);
    List<RandevuDto> tumRandevulariGetir();
    RandevuDto randevuGuncelle(Long randevuId,RandevuDto guncellenenRandevu);
    void randevuSil(Long randevuId);

}
