package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.MusteriDto;
import com.example.kuaforrandevu.dto.RandevuDto;
import com.example.kuaforrandevu.entity.Admin;
import com.example.kuaforrandevu.entity.Musteri;
import com.example.kuaforrandevu.entity.Randevu;
import com.example.kuaforrandevu.mapper.AdminMapper;
import com.example.kuaforrandevu.mapper.MusteriMapper;
import com.example.kuaforrandevu.mapper.RandevuMapper;
import com.example.kuaforrandevu.repository.MusteriRepository;
import com.example.kuaforrandevu.repository.RandevuRepository;
import com.example.kuaforrandevu.service.RandevuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RandevuServiceImpl implements RandevuService {
    private RandevuRepository randevuRepository;

    @Override
    public RandevuDto randevuYarat(RandevuDto randevuDto) {
        Randevu randevu = RandevuMapper.mapToRandevu(randevuDto);
        Randevu kaydedilmisRandevu = randevuRepository.save(randevu);
        return RandevuMapper.mapToRandevuDto(kaydedilmisRandevu);
    }

    @Override
    public RandevuDto idIleGetir(Long randevuId) {
        Randevu randevu=randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+randevuId));
        return RandevuMapper.mapToRandevuDto(randevu);
    }

    @Override
    public List<RandevuDto> tumRandevulariGetir() {
        List<Randevu>randevular=randevuRepository.findAll();
        return randevular.stream().map(randevu -> RandevuMapper.mapToRandevuDto(randevu)).collect(Collectors.toList());
    }

    @Override
    public RandevuDto randevuGuncelle(Long randevuId, RandevuDto guncellenenRandevu) {
        Randevu randevu=randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+randevuId));
        randevu.setMusteriisim(guncellenenRandevu.getMusteriisim());
        randevu.setSaat(guncellenenRandevu.getSaat());
        randevu.setIslem(guncellenenRandevu.getIslem());
        randevu.setGun(guncellenenRandevu.getGun());
        randevu.setKuaforAd(guncellenenRandevu.getKuaforAd());
        randevuRepository.save(randevu);
        Randevu veriTabaniGuncellenmisRandevu=randevuRepository.save(randevu);
        return RandevuMapper.mapToRandevuDto(veriTabaniGuncellenmisRandevu);
    }

    @Override
    public void randevuSil(Long randevuId) {
        Randevu randevu=randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+randevuId));
        randevuRepository.deleteById(randevuId);

    }


}
