package com.hospital_vm.cl.hospital_vm.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ficha_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String datos_personales;

    @Column(length = 100)
    private String datos_personales_2;

    @Column(length = 100)
    private String datos_personales_3;

    @Column(length = 100)
    private String datos_personales_4;

    @Column(length = 100)
    private String datos_personales_5;
}
