package com.example.kuaforrandevu.service;

import com.example.kuaforrandevu.dto.KuaforDto;

import java.util.List;

public interface KuaforService {
    KuaforDto kuaforYarat(KuaforDto kuaforDto);
    KuaforDto idIleGetir(Long kuaforId);
    List<KuaforDto> tumPersonelleriGetir();
    KuaforDto kuaforGuncelle(Long kuaforId,KuaforDto guncellenenKuafor);

    void kuaforSil(Long kuaforId);
}
