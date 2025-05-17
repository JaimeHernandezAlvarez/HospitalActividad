package com.hospital_vm.cl.hospital_vm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.repository.FichaPacienteRepository;
import com.hospital_vm.cl.hospital_vm.model.FichaPaciente;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FichaPacienteService {
    @Autowired
    private FichaPacienteRepository fichaPacienteRepository;

    //Listar todas las fichas
    public List<FichaPaciente> findAll(){
        return fichaPacienteRepository.findAll();
    }

    //Listar por ID
    public FichaPaciente findById(long id){
        return fichaPacienteRepository.findById(id).get();
    }

    //Guardar ficha
    public FichaPaciente save(FichaPaciente fichaPaciente){
        return fichaPacienteRepository.save(fichaPaciente);
    }

    //Eliminar Ficha
    public void delete(long id){
        fichaPacienteRepository.deleteById(id);
    }
}
