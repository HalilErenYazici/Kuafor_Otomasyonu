package com.example.kuaforrandevu.service;

import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.dto.MusteriDto;

import java.util.List;


public interface MusteriService  {
    MusteriDto musteriYarat(MusteriDto musteriDto);
    MusteriDto idIleGetir(Long musteriId);
    List<MusteriDto> tumMusterileriGetir();
    MusteriDto musteriGuncelle(Long musteriId,MusteriDto guncellenenMusteri);
    void musteriSil(Long musteriId);


}
