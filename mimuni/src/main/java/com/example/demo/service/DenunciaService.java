package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.modelo.Denuncia;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.DenunciaRepository;

@Service
public class DenunciaService {
	@Autowired
	DenunciaRepository denunciaRepository;
	@Autowired
	VecinoService vecinoservice;

	@Autowired
	SitioService sitioService;

	public String generarDenuncia(String mail, String descripcion, Integer idSitio, int aceptaResponsabilidad) {
//		Aca tenemsos el documento
		Vecino vecino = vecinoservice.perfilVecinoregistrado(mail);
		if (vecino != null) {
			// Validamos el sitio
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {
				// Validamos desperfecto

				if (aceptaResponsabilidad != 1) {
					Denuncia nuevaDenuncia = new Denuncia(descripcion, aceptaResponsabilidad, vecino, sitio);

					denunciaRepository.save(nuevaDenuncia);

					return "denuncia generada con exito";

				} else {
					return "no acepta responsabilidad";
				}

			} else {
				return "Sitio no encontrado";
			}
		} else {
			return "Vecino no encontrado";
		}
	}
	public Denuncia traerDenuncia(Integer iddenuncia) {
		return denunciaRepository.findByidDenuncia(iddenuncia);
		
	}
}
