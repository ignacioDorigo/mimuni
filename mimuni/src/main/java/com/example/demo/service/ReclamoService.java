package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Reclamo;
import com.example.demo.repository.ReclamoRepository;

@Service
public class ReclamoService {
	@Autowired
	ReclamoRepository repositorio;
    public Reclamo crearReclamo(Reclamo reclamo) {
        return repositorio.save(reclamo);
    }	
}
