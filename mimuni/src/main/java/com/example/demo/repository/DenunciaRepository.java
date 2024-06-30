package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer>  {

	Optional<Denuncia>  findByidDenuncia(Integer iddenuncia);

}
