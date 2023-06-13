package com.suarez.examenpracticom5a.controller;

import com.suarez.examenpracticom5a.modelo.Empleado;
import com.suarez.examenpracticom5a.modelo.Trabajo;
import com.suarez.examenpracticom5a.service.EmpleadoServicelmpl;
import com.suarez.examenpracticom5a.service.TrabajoServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clase2")
public class TrabajoController {

    @Autowired
    TrabajoServicelmpl trabajoServicelmpl;

    @Autowired
    EmpleadoServicelmpl empleadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Trabajo>> listaPersona() {
        return new ResponseEntity<>(trabajoServicelmpl.findByAll(), HttpStatus.OK);
    }


    @PostMapping("/crear")
    public ResponseEntity<Trabajo> crearTrabajo(@RequestParam ("id_empleado") int id_empleado,@RequestBody Trabajo u) {
        Empleado empleados = empleadoService.findById(id_empleado);
        if(empleados.getDias_trabajo()<=20){
            double sueldo_total = ((empleados.getDias_trabajo()*15));
            u.setSueldo_total(sueldo_total);
            return new ResponseEntity<>(trabajoServicelmpl.save(u), HttpStatus.CREATED);
        }
        if(empleados.getDias_trabajo()>=20 && empleados.getDias_trabajo()<30){
            double sueldo_total2 =  ((empleados.getDias_trabajo()*15)+(empleados.getDias_trabajo()*15)*0.2);
            u.setSueldo_total(sueldo_total2);
            return new ResponseEntity<>(trabajoServicelmpl.save(u), HttpStatus.CREATED);
        }else{
            double sueldo_total2 =  ((empleados.getDias_trabajo()*15)+(empleados.getDias_trabajo()*15)*0.5);
            u.setSueldo_total(sueldo_total2);
            return new ResponseEntity<>(trabajoServicelmpl.save(u), HttpStatus.CREATED);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Trabajo> actualizarPersona(@PathVariable Integer id, @RequestBody Trabajo u) {
        Trabajo persona = trabajoServicelmpl.findById(id);
        if (persona != null) {
            try {
                //persona.setNombre_per(u.getNombre_per());
                return new ResponseEntity<>(trabajoServicelmpl.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trabajo> eliminarPersona(@PathVariable Integer id) {
        trabajoServicelmpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
