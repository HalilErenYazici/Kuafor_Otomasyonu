package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.Kuafor;
import com.example.kuaforrandevu.repository.KuaforRepository;
import com.example.kuaforrandevu.service.KuaforService;
import lombok.AllArgsConstructor;
import com.example.kuaforrandevu.mapper.KuaforMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class KuaforServiceImpl implements KuaforService {
    private KuaforRepository kuaforRepository;
    @Override
    public KuaforDto kuaforYarat(KuaforDto kuaforDto) {
        Kuafor kuafor= KuaforMapper.mapToKuafor(kuaforDto);
        Kuafor kaydedilmisKuafor=kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(kaydedilmisKuafor);
    }

    @Override
    public KuaforDto idIleGetir(Long kuaforId) {
        Kuafor kuafor=kuaforRepository.findById(kuaforId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir personel bulunamadı. id: "+kuaforId));
        return KuaforMapper.mapToKuaforDto(kuafor);

    }


}
