package com.hospital_vm.cl.hospital_vm.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mdeico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String run_medico;

    @Column(length = 100)
    private String nombre_completo;

    @Column(length = 100)
    private String especialidad;

    @Column(length = 1)
    private String jefe_turno;
}
