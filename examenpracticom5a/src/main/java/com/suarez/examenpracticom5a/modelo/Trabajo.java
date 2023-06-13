package com.suarez.examenpracticom5a.modelo;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajo")
    private int id_trabajo;


    @Column(name = "sueldo_total")
    private double sueldo_total;


    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;

}
