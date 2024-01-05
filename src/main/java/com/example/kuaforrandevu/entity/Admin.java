package com.example.kuaforrandevu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adminler")
public class Admin {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)

          private long adminId;

    private String adminSifre;
        @Column(nullable = false,unique = true)
        private String kullaniciAdi;

        @Column(nullable = false,unique = true)
        private String adminMail;

}
