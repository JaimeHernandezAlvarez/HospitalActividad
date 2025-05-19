package com.hospital_vm.cl.hospital_vm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.repository.AtencionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtencionService {

    @Autowired
    public AtencionRepository atencionRepository;

    //Listar todas las atenciones
    public List<Atencion> findAll(){
        return atencionRepository.findAll();
    }

    //Listar atencion por id
    public Atencion findById(long id){
        return atencionRepository.findById(id).get();
    }

    //Guardar atencion
    public Atencion save(Atencion atencion){
        return atencionRepository.save(atencion);
    }

    //Borrar atención
    public void delete(long id){
        atencionRepository.deleteById(id);
    }
}
