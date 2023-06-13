package com.suarez.examenpracticom5a.repository;

import com.suarez.examenpracticom5a.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "Select * from persona u where u.nombre = :nombre", nativeQuery = true)
    public Empleado buscarPersona(String nombre);
}