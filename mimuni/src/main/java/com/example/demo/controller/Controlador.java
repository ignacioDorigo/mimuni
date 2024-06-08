package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Personal;
import com.example.demo.service.PersonalService;

@RestController
@RequestMapping("/inicio")
public class Controlador {
	@Autowired
	PersonalService personalservice;
	
	@PostMapping("/loginInspector")
	public ResponseEntity<String> loginInspector(@RequestParam Integer legajo, @RequestParam String password){
		boolean resultado = personalservice.loginInspector(legajo, password);
		if(resultado == true) {
			return ResponseEntity.ok("Login exitoso");
		}else {
			return ResponseEntity.status(401).body("Datos incorrectos");
		}
	}
	@GetMapping("/inspectores")
	public List<Personal> inspectores(){
		return personalservice.inspectores();
	}
}
