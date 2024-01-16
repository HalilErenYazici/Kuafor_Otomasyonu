package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.dto.KuaforDto;
import com.example.kuaforrandevu.entity.Admin;
import com.example.kuaforrandevu.entity.BizeUlas;
import com.example.kuaforrandevu.entity.Randevu;
import com.example.kuaforrandevu.mapper.AdminMapper;
import com.example.kuaforrandevu.mapper.BizeUlasMapper;
import com.example.kuaforrandevu.mapper.RandevuMapper;
import com.example.kuaforrandevu.repository.AdminRepository;
import com.example.kuaforrandevu.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminImpl implements AdminService {
    private AdminRepository adminRepository;
    @Override
    public AdminDto adminYarat(AdminDto adminDto) {
        Admin admin= AdminMapper.mapToAdmin(adminDto);
        Admin kaydedilmisAdmin=adminRepository.save(admin);

        return AdminMapper.mapToAdminDto(kaydedilmisAdmin);    }

    @Override
    public AdminDto idIleGetir(Long adminId) {
        Admin admin=adminRepository.findById(adminId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+adminId));
        return AdminMapper.mapToAdminDto(admin);     }

    @Override
    public List<AdminDto> tumAdminleriGetir() {
        List<Admin>adminler=adminRepository.findAll();
        return adminler.stream().map(admin -> AdminMapper.mapToAdminDto(admin)).collect(Collectors.toList());
    }

    @Override
    public AdminDto adminGuncelle(Long adminId, AdminDto guncellenenAdmin) {
        Admin admin=adminRepository.findById(adminId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+adminId));
        admin.setAdsoyad(guncellenenAdmin.getAdsoyad());
        admin.setEmail(guncellenenAdmin.getEmail());
        admin.setSifre(guncellenenAdmin.getSifre());

        adminRepository.save(admin);
        Admin veriTabaniGuncellenmisAdmin=adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(veriTabaniGuncellenmisAdmin);
    }

    @Override
    public void adminSil(Long adminId) {
        Admin admin=adminRepository.findById(adminId)
                .orElseThrow(()->new KaynakBulunamadiException("bu id ile kayıtlı bir admin bulunamadı. id: "+adminId));
        adminRepository.deleteById(adminId);

    }

}
