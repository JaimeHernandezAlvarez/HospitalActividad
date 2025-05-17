package com.hospital_vm.cl.hospital_vm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.TipoUsuario;
import com.hospital_vm.cl.hospital_vm.repository.TipoUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    //Listar todos los tipos de usuario
    public List<TipoUsuario> findAll(){
        return tipoUsuarioRepository.findAll();
    }

    //Listar tipo por Id
    public TipoUsuario findById(long id){
        return tipoUsuarioRepository.findById(id).get();
    }

    //Guardar Tipo de usuario
    public TipoUsuario save(TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    //Eliminar Tipo de Usuario
    public void delete(long id){
        tipoUsuarioRepository.deleteById(id);
    }
}
