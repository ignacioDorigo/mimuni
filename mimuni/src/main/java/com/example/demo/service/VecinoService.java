package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.VecinoRepository;
import com.example.demo.repository.VecinoregistradoRepository;

@Service
public class VecinoService {
	@Autowired
	VecinoRepository repoVecino;
	@Autowired
	VecinoregistradoRepository repoVecinoRegistrado;
	
//	public String register(String documento, String mail) {
//        Optional<Vecinoregistrado> vecinoYaRegistrado = repoVecinoRegistrado.findById(documento);
//        if (vecinoYaRegistrado.isPresent()) {
//            return "YA ESTAS REGISTRADO";
//        } else {
//            Optional<Vecino> vecinoOptional = repoVecino.findById(documento);
//            if (vecinoOptional.isPresent()) {
//                String contrasenia = documento;
//                Vecinoregistrado nuevoVecino = new Vecinoregistrado(documento, mail, contrasenia, "B", "S");
//                repoVecinoRegistrado.save(nuevoVecino);
//                return "Registro exitoso";
//            } else {
//                return "No puede registrarse porque no es vecino";
//            }
//        }
//    }
	
	
	public String register2(String documento, String mail) {
        Optional<Vecinoregistrado> vecinoYaRegistrado = repoVecinoRegistrado.findById(documento);
        if (vecinoYaRegistrado.isPresent()) {
            return "YA ESTAS REGISTRADO";
        } else {
            Optional<Vecino> vecinoOptional = repoVecino.findById(documento);
            if (vecinoOptional.isPresent()) {
            	List<Vecinoregistrado> mails = repoVecinoRegistrado.findByMail(mail);
            	for(Vecinoregistrado v : mails) {
            		if(v.getMail().equals(mail)) {
            			return "El mail ya existe";
            		}
            	}
                String contrasenia = documento;
                Vecinoregistrado nuevoVecino = new Vecinoregistrado(documento, mail, contrasenia, "B", "S");
                repoVecinoRegistrado.save(nuevoVecino);
                return "Registro exitoso";
            } else {
                return "No puede registrarse porque no es vecino";
            }
        }
    }
	
	
	
	public String login(String mail, String contrasenia) {
		List<Vecinoregistrado> mails = repoVecinoRegistrado.findByMail(mail);
		Vecinoregistrado vecino = null;
		for(Vecinoregistrado v : mails) {
			vecino = v;
		}
		if(vecino == null) {
			return "No estas registrado";
		}else {
			if(vecino.getMail().equals(mail) && vecino.getContrasenia().equals(contrasenia)) {
				if(vecino.getEstado().equals("B")) {
					return "Tu cuenta no está habilitada";
				}else {
					return "Ingreso exitoso";
				}
				
			}
			else {
				return "Datos incorrectos";
			}
		}
	}
		
	
	 
}
