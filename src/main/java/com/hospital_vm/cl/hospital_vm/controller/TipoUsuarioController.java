package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.TipoUsuario;
import com.hospital_vm.cl.hospital_vm.service.TipoUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/tipoUsuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listar(){
        List<TipoUsuario> tipoUsuarios = tipoUsuarioService.findAll();
        if(tipoUsuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoUsuarios);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> guardar(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipo = tipoUsuarioService.save(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscar(@PathVariable Integer id){
        try{
            TipoUsuario tipoUsuario = tipoUsuarioService.findById(id);
            return ResponseEntity.ok(tipoUsuario);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizar(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario){
        try{
            TipoUsuario tipo = tipoUsuarioService.findById(id);
            tipo.setId(id);
            tipo.setNombre(tipo.getNombre());

            tipoUsuarioService.save(tipo);
            return ResponseEntity.ok(tipo);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
}
