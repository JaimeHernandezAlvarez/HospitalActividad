package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospital_vm.cl.hospital_vm.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
