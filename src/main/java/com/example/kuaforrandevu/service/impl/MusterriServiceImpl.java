package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.dto.MusteriDto;

import com.example.kuaforrandevu.entity.Kuafor;
import com.example.kuaforrandevu.entity.Musteri;
import com.example.kuaforrandevu.mapper.KuaforMapper;
import com.example.kuaforrandevu.mapper.MusteriMapper;

import com.example.kuaforrandevu.repository.MusteriRepository;
import com.example.kuaforrandevu.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MusterriServiceImpl implements MusteriService {
    private MusteriRepository musteriRepository;

    @Override
    public MusteriDto musteriYarat(MusteriDto musteriDto) {
        Musteri musteri = MusteriMapper.mapToMusteri(musteriDto);
        Musteri kaydedilmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(kaydedilmisMusteri);
    }

    @Override
    public MusteriDto idIleGetir(Long musteriId) {
        Musteri musteri=musteriRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir musteri bulunamadı. id: "+musteriId));
        return MusteriMapper.mapToMusteriDto(musteri);
    }
    @Override
    public List<MusteriDto> tumMusterileriGetir() {
        List<Musteri> musteriler=musteriRepository.findAll();
        return musteriler.stream().map((musteri -> MusteriMapper.mapToMusteriDto(musteri)))
                .collect(Collectors.toList());
    }

    @Override
    public MusteriDto musteriGuncelle(Long musteriId, MusteriDto guncellenenMusteri) {
        Musteri musteri=musteriRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir müşteri bulunamadı. id: "+musteriId));
        musteri.setMusteriisim(guncellenenMusteri.getMusteriisim());
        musteri.setMusterisoyisim(guncellenenMusteri.getMusterisoyisim());
        musteri.setMusterisifre(guncellenenMusteri.getMusterisifre());
        musteri.setEposta(guncellenenMusteri.getEposta());

        musteriRepository.save(musteri);
        Musteri veritabanindaGuncellenmisMusteri=musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(veritabanindaGuncellenmisMusteri);
    }

    @Override
    public void musteriSil(Long musteriId) {
        Musteri musteri=musteriRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir musteri bulunamadı. id: "+musteriId));

        musteriRepository.deleteById(musteriId);
    }


}