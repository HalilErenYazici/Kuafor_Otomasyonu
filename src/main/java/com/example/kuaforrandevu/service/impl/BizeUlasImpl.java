package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.BizeUlasDto;
import com.example.kuaforrandevu.entity.BizeUlas;
import com.example.kuaforrandevu.entity.Kuafor;
import com.example.kuaforrandevu.mapper.BizeUlasMapper;
import com.example.kuaforrandevu.mapper.KuaforMapper;
import com.example.kuaforrandevu.repository.BizeUlasRepository;
import com.example.kuaforrandevu.service.BizeUlasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BizeUlasImpl implements BizeUlasService {
    private BizeUlasRepository bizeUlasRepository;

    @Override
    public BizeUlasDto bizeUlasYarat(BizeUlasDto bizeUlasDto) {
        BizeUlas bizeUlas=BizeUlasMapper.mapToBizeUlas(bizeUlasDto);
        BizeUlas kaydedilmisBizeUlas=bizeUlasRepository.save(bizeUlas);

        return BizeUlasMapper.mapToBizeUlasDto(kaydedilmisBizeUlas);
    }

    @Override
    public BizeUlasDto idIleGetir(Long bizeUlasId) {
        BizeUlas bizeUlas=bizeUlasRepository.findById(bizeUlasId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir personel bulunamadı. id: "+bizeUlasId));
        return BizeUlasMapper.mapToBizeUlasDto(bizeUlas);    }

    @Override
    public List<BizeUlasDto> tumBizeUlasinlariGetir() {
        List<BizeUlas> bizeUlaslar=bizeUlasRepository.findAll();
        return bizeUlaslar.stream().map((bizeUlas -> BizeUlasMapper.mapToBizeUlasDto(bizeUlas)))
                .collect(Collectors.toList());
    }

    @Override
    public void BizeUlasSil(Long bizeUlasId) {
        BizeUlas bizeUlas=bizeUlasRepository.findById(bizeUlasId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir personel bulunamadı. id: "+bizeUlasId));
        bizeUlasRepository.deleteById(bizeUlasId);

    }
}
