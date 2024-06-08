package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Barrio;
import com.example.demo.modelo.Personal;
import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.*;

@SpringBootApplication
public class MimuniApplication implements CommandLineRunner {

	@Autowired
	BarrioRepository repobarrio;

	@Autowired
	VecinoRepository repovecino;

	@Autowired
	VecinoregistradoRepository repovecinoregistrado;
	
	@Autowired
	PersonalRepository repopersonal;

	public static void main(String[] args) {
		SpringApplication.run(MimuniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		mostrarBarrios();
//		mostrarVecinos();
//		register("DNI28000429", "ignaciodorigo@nacho0305sadasd.com.ar");
//		mostrarVecinosRegistrados();
		mostrarPersonal();

	}

	public void mostrarBarrios() {
		List<Barrio> barrios = repobarrio.findAll();
		for (Barrio barrio : barrios) {
			System.out.println(barrio);
		}
	}

	public void mostrarVecinos() {
		List<Vecino> vecinos = repovecino.findAll();
		for (Vecino vecino : vecinos) {
			System.out.println(vecino);
		}
	}

	public void mostrarVecinosRegistrados() {
//		System.out.println("Vecinos registrados");
		List<Vecinoregistrado> vecinos = repovecinoregistrado.findAll();
		for (Vecinoregistrado vecino : vecinos) {
			System.out.println(vecino);
		}
	}

	public void register(String documento, String mail) {
		Optional<Vecinoregistrado> vecinoYaRegistrado = repovecinoregistrado.findById(documento);
		if (vecinoYaRegistrado.isPresent()) {
			System.out.println("YA ESTAS REGISTRADO");
		} else {
			Optional<Vecino> vecinoOptional = repovecino.findById(documento);
			if (vecinoOptional.isPresent()) {
				String contrasenia = documento;
				Vecinoregistrado nuevoVecino = new Vecinoregistrado(documento, mail, contrasenia, "B", "S");
				repovecinoregistrado.save(nuevoVecino);
				System.out.println("Registro exitoso");
			} else {
				System.out.println("No puede registrarse xq no es vecino");
			}
		}
	}
	
	public void mostrarPersonal() {
		List<Personal> inspectores = repopersonal.findAll();
		for(Personal inspector: inspectores) {
			System.out.println(inspector);
		}
	}

}
