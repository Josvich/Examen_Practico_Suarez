package com.suarez.examenpracticom5a.service;

import com.suarez.examenpracticom5a.modelo.Empleado;
import com.suarez.examenpracticom5a.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicelmpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado,Integer> {

    @Autowired
    EmpleadoRepository empleadoRepository;


    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoRepository;
    }
}
