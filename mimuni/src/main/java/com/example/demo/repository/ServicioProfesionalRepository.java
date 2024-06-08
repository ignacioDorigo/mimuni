package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.ServicioProfesional;
import java.util.List;

public interface ServicioProfesionalRepository extends JpaRepository<ServicioProfesional, Integer> {

	public List<ServicioProfesional> findByEstado(String estado);
}
