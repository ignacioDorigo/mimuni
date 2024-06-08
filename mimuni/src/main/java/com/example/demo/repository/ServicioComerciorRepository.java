package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.ServicioComercio;
import java.util.List;


public interface ServicioComerciorRepository extends JpaRepository<ServicioComercio, Integer> {

	public List<ServicioComercio> findByEstado(String estado);
}
