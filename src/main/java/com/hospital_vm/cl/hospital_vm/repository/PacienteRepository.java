package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.stereotype.Repository;
import com.hospital_vm.cl.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
