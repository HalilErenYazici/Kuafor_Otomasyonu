package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.dto.MusteriDto;

import com.example.kuaforrandevu.entity.Musteri;
import com.example.kuaforrandevu.mapper.MusteriMapper;

import com.example.kuaforrandevu.repository.MusteriRepository;
import com.example.kuaforrandevu.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

}