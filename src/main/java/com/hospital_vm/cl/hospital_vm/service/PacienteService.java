package com.hospital_vm.cl.hospital_vm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    //Listar todos los pacientes
    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    //Listar un solo paciente por id
    public Paciente findById(long id){
        return pacienteRepository.findById(id).get();
    }

    //Guardar paciente
    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    //Eliminar paciente
    public void delete(long id){
        pacienteRepository.deleteById(id);
    }
}
