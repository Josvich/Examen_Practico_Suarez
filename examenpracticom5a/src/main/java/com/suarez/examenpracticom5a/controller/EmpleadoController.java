package com.suarez.examenpracticom5a.controller;

import com.suarez.examenpracticom5a.modelo.Empleado;
import com.suarez.examenpracticom5a.service.EmpleadoServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clase1")
public class EmpleadoController {

    @Autowired
    EmpleadoServicelmpl empleadoServicelmpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaPersona() {
        return new ResponseEntity<>(empleadoServicelmpl.findByAll(), HttpStatus.OK);
    }


    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado u) {
        return new ResponseEntity<>(empleadoServicelmpl.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado u) {
        Empleado persona = empleadoServicelmpl.findById(id);
        if (persona != null) {
            try {
                //persona.setNombre_per(u.getNombre_per());

                return new ResponseEntity<>(empleadoServicelmpl.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> eliminarPersona(@PathVariable Integer id) {
        empleadoServicelmpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
