package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.service.AtencionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping()
public class AtencionController {
    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar(){
        List<Atencion> atenciones = atencionService.findAll();

        if(atenciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        Atencion atenc = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(atenc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscar(@PathVariable Integer id){
        try{
            Atencion atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody Atencion atencion) {        
        try{
            Atencion ate = atencionService.findById(id);
            ate.setId(id);
            ate.setFecha_atencion(atencion.getFecha_atencion());
            ate.setHora_atencion(atencion.getHora_atencion());
            ate.setCosto(atencion.getCosto());
            ate.setId_paciente(atencion.getId_paciente());
            ate.setId_medico(atencion.getId_medico());
            ate.setComentario(atencion.getComentario());

            atencionService.save(ate);
            return ResponseEntity.ok(ate);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
