package com.suarez.examenpracticom5a.service;

import com.suarez.examenpracticom5a.modelo.Trabajo;
import com.suarez.examenpracticom5a.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TrabajoServicelmpl extends GenericServiceImpl<Trabajo, Integer> implements GenericService<Trabajo, Integer>{

    @Autowired
    TrabajoRepository trabajoRepository;


    @Override
    public CrudRepository<Trabajo, Integer> getDao() {
        return trabajoRepository;
    }
}
