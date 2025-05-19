package com.hospital_vm.cl.hospital_vm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicoService {
    
    @Autowired
    public MedicoRepository medicoRepository;

    //Listar todos los medicos
    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    //Listar atencion por id
    public Medico findById(long id){
        return medicoRepository.findById(id).get();
    }

    //Guardar atencion
    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    //Borrar atención
    public void delete(long id){
        medicoRepository.deleteById(id);
    }
}
