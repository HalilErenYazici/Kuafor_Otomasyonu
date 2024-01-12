package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.Kuafor;
import com.example.kuaforrandevu.repository.KuaforRepository;
import com.example.kuaforrandevu.service.KuaforService;
import lombok.AllArgsConstructor;
import com.example.kuaforrandevu.mapper.KuaforMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<KuaforDto> tumPersonelleriGetir() {
        List<Kuafor> kuaforler=kuaforRepository.findAll();
        return kuaforler.stream().map((kuafor -> KuaforMapper.mapToKuaforDto(kuafor)))
                .collect(Collectors.toList());
    }

    @Override
    public KuaforDto kuaforGuncelle(Long kuaforId, KuaforDto guncellenenKuafor) {
        Kuafor kuafor=kuaforRepository.findById(kuaforId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir personel bulunamadı. id: "+kuaforId));
        kuafor.setIsim(guncellenenKuafor.getIsim());
        kuafor.setSoyisim(guncellenenKuafor.getSoyisim());
        kuafor.setEposta(guncellenenKuafor.getEposta());
        kuafor.setSifre(guncellenenKuafor.getSifre());
        kuaforRepository.save(kuafor);
        Kuafor veritabanindaGuncellenmisKuafor=kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(veritabanindaGuncellenmisKuafor);
 
    }

    @Override
    public void kuaforSil(Long kuaforId) {
        Kuafor kuafor=kuaforRepository.findById(kuaforId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir personel bulunamadı. id: "+kuaforId));
        kuaforRepository.deleteById(kuaforId);
    }


}
