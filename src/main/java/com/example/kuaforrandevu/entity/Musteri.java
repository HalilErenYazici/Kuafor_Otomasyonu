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
@Table(name="musteriler")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String Musteriisim;
    private String Musterisoyisim;
    private String Musterisifre;
    @Column(name="eposta_id",nullable = false,unique = true)

    private String eposta;
}


