package com.hospital_vm.cl.hospital_vm.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha_atencion;

    @Column(nullable = false)
    private Date hora_atencion;

    @Column(nullable = false,precision = 10,scale = 2)
    private Number costo;
    
    @Column(length = 10)
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    
    @Column(length = 10)
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    
    @Column(nullable = true,length = 300)
    private String comentario;
}
