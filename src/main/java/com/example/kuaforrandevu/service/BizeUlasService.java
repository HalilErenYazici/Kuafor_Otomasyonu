package com.example.kuaforrandevu.service;

import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.dto.KuaforDto;

import java.util.List;

public interface BizeUlasService {
    BizeUlasDto bizeUlasYarat(BizeUlasDto bizeUlasDto);
    BizeUlasDto idIleGetir(Long bizeUlasId);
    List<BizeUlasDto> tumBizeUlasinlariGetir();
    void BizeUlasSil(Long bizeUlasId);
}
