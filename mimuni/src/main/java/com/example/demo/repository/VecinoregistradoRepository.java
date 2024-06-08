package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Vecinoregistrado;
import java.util.List;


public interface VecinoregistradoRepository extends JpaRepository<Vecinoregistrado, String> {
	public List<Vecinoregistrado> findByMail(String mail);
}
