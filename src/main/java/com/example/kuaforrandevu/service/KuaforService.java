package com.example.kuaforrandevu.service;

import com.example.kuaforrandevu.dto.KuaforDto;

public interface KuaforService {
    KuaforDto kuaforYarat(KuaforDto kuaforDto);
    KuaforDto idIleGetir(Long kuaforId);
}
