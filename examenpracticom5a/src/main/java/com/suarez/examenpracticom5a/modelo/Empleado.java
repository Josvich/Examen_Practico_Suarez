package com.suarez.examenpracticom5a.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    //@NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;

    //@NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dias_trabajo")
    private int dias_trabajo;




    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<Trabajo>listaTrabajo;
}
