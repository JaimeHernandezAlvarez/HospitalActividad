package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.FichaPaciente;
import com.hospital_vm.cl.hospital_vm.service.FichaPacienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/fichas")
public class FichaPacienteController{
    @Autowired
    private FichaPacienteService fichaPacienteService;

    @GetMapping
    public ResponseEntity<List<FichaPaciente>> listar(){
        List<FichaPaciente> fichaPaciente = fichaPacienteService.findAll();
        if(fichaPaciente.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fichaPaciente);
    }

    @PostMapping
    public ResponseEntity<FichaPaciente> guardar(@RequestBody FichaPaciente fichaPaciente){
        FichaPaciente ficha = fichaPacienteService.save(fichaPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ficha);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FichaPaciente> buscar(@PathVariable Integer id){
        try{
            FichaPaciente fichaPaciente = fichaPacienteService.findById(id);
            return ResponseEntity.ok(fichaPaciente);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaPaciente> actualizar(@PathVariable Integer id, @RequestBody FichaPaciente fichaPaciente){
        try{
            FichaPaciente ficha = fichaPacienteService.findById(id);
            ficha.setDatos_personales(fichaPaciente.getDatos_personales());
            ficha.setDatos_personales_2(fichaPaciente.getDatos_personales_2());
            ficha.setDatos_personales_3(fichaPaciente.getDatos_personales_3());
            ficha.setDatos_personales_4(fichaPaciente.getDatos_personales_4());
            ficha.setDatos_personales_5(fichaPaciente.getDatos_personales_5());
            fichaPacienteService.save(ficha);
            return ResponseEntity.ok(fichaPaciente);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            fichaPacienteService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
}
