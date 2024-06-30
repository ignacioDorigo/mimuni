package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.modelo.Personal;
import com.example.demo.modelo.ServicioComercio;
import com.example.demo.modelo.ServicioProfesional;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.service.PersonalService;
import com.example.demo.service.ReclamoService;
import com.example.demo.service.ServicioComercioService;
import com.example.demo.service.ServicioProfesionalService;
import com.example.demo.service.VecinoService;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/inicio")
public class Controlador {
	@Autowired
	PersonalService personalservice;

	@Autowired
	VecinoService vecinoservice;

	@Autowired
	ServicioProfesionalService profesionalservice;

	@Autowired
	ServicioComercioService comercioservice;
	
	@Autowired
	ReclamoService reclamoservice;
	

	@PostMapping("/loginInspector")
	public ResponseEntity<String> loginInspector(@RequestParam Integer legajo, @RequestParam String password) {
		boolean resultado = personalservice.loginInspector(legajo, password);
		if (resultado == true) {
			return ResponseEntity.ok("Login exitoso");
		} else {
			return ResponseEntity.status(401).body("Datos incorrectos");
		}
	}

	@GetMapping("/inspectores")
	public List<Personal> inspectores() {
		return personalservice.inspectores();
	}

	@PutMapping("/cambiarPassword")
	public ResponseEntity<String> cambiarPassword(@RequestParam Integer legajo, @RequestParam String passwordActual,
			@RequestParam String passwordNueva, @RequestParam String passwordNueva2) {
		boolean resultado = personalservice.cambiarPassword(legajo, passwordActual, passwordNueva, passwordNueva2);
		if (resultado) {
			return ResponseEntity.ok("Cambio de contraseña exitoso");
		} else {
			return ResponseEntity.status(400).body("Error al cambiar la contraseña");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestParam String documento, @RequestParam String mail) {
		String resultado = vecinoservice.register2(documento, mail);
		if (resultado.equals("Registro exitoso")) {
			return ResponseEntity.ok(resultado);
		} else {
//			System.out.println("Entro aca	");
			return ResponseEntity.status(400).body(resultado);
		}
	}

	@PostMapping("/loginVecino")
	public ResponseEntity<String> loginVecino(@RequestParam String mail, @RequestParam String contrasenia) {
		String resultado = vecinoservice.login(mail, contrasenia);
		if (resultado.equals("Ingreso exitoso")) {
			return ResponseEntity.ok(resultado);
		} else {
			return ResponseEntity.status(400).body(resultado);
		}
	}

	@GetMapping("/servicios/profesionales")
	public List<ServicioProfesional> serviciosProfesionales() {
		return profesionalservice.serviciosProfesionalesHabilitados();
	}

	@GetMapping("/servicios/comercios")
	public List<ServicioComercio> servicioComercios() {
		return comercioservice.serviciosComerciosHabilitados();
	}
	

	@PostMapping("/vecino/olvidecontrasenia")
    public ResponseEntity<String> olvideContrasenia(@RequestParam String mail) {
        String resultado = vecinoservice.olvideContrasenia(mail);
        if (resultado.equals("Correo enviado correctamente")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(400).body(resultado);
        }
    }
	@PostMapping("/vecino/generarReclamo")
    public ResponseEntity<String> generarReclamo(@RequestParam String mail,@RequestParam Integer idSitio, @RequestParam  Integer idDesperfecto,@RequestParam String descripcion,
    		@RequestParam MultipartFile[] files) {
        String resultado = vecinoservice.olvideContrasenia(mail);
        if (resultado.equals("Correo enviado correctamente")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(400).body(resultado);
        }
    }

}
