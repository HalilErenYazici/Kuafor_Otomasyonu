package com.example.kuaforrandevu.service.impl;

import com.example.kuaforrandevu.dto.AdminDto;
import com.example.kuaforrandevu.entity.Admin;
import com.example.kuaforrandevu.entity.Kuafor;
import com.example.kuaforrandevu.mapper.AdminMapper;
import com.example.kuaforrandevu.mapper.KuaforMapper;
import com.example.kuaforrandevu.repository.AdminRepository;
import com.example.kuaforrandevu.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    @Override
    public AdminDto adminYarat(AdminDto adminDto) {
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        Admin kaydedilmisAdmin=adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(kaydedilmisAdmin);    }

}
