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
@Table(name="kuaforler")
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String kuaforSalonAd;
    private String isim;
    private String soyisim;
    private String sifre;
    @Column(name="eposta_id",nullable = false,unique = true)

    private String eposta;
}
