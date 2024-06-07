package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Barrio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.*;

@SpringBootApplication
public class MimuniApplication implements CommandLineRunner{
	
	@Autowired
	BarrioRepository repobarrio;
	@Autowired
	VecinoRepository repovecino;
	
	public static void main(String[] args) {
		SpringApplication.run(MimuniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//mostrarBarrios();
		mostrarVecinos();
		
	}
	
	public void mostrarBarrios() {
		List<Barrio> barrios = repobarrio.findAll();
		for(Barrio barrio : barrios) {
			System.out.println(barrio);
		}
	}
	
	
	public void mostrarVecinos() {
		List<Vecino> vecinos = repovecino.findAll();
		for(Vecino vecino : vecinos) {
			System.out.println(vecino);
		}
	}

}
