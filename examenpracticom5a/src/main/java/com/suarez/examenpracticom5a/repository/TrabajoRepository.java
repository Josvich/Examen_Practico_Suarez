package com.suarez.examenpracticom5a.repository;

import com.suarez.examenpracticom5a.modelo.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    @Query(value = "Select * from persona u where u.nombre_per = :nombre_per", nativeQuery = true)
    public Trabajo buscarPersona(String nombre);
}
