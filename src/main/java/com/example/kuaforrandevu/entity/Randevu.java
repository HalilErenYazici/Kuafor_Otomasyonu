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
@Table(name="randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
        private String Musteriisim;
    private String KuaforAd;
    private String islem;
    private String gun;
    private String saat;
    private String onay;

}
