package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.UploadFilesService;
import com.example.demo.modelo.Desperfecto;
import com.example.demo.modelo.MovimientoReclamo;
import com.example.demo.modelo.Personal;
import com.example.demo.modelo.Reclamo;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.ImagenReclamoRepository;
import com.example.demo.repository.MovimientoReclamoRepository;
import com.example.demo.repository.ReclamoRepository;

@Service
public class ReclamoService {

	@Autowired
	ReclamoRepository reclamoRepository;

	@Autowired
	ImagenReclamoRepository imagenReclamoRepository;

	@Autowired
	VecinoService vecinoservice;

	@Autowired
	SitioService sitioService;

	@Autowired
	DesperfectoService desperfectoService;
	
	@Autowired
	PersonalService personalService;

	@Autowired
	UploadFilesService guardarImagenes;

	@Autowired
	MovimientoReclamoRepository movimientoReclamoRepository;

	public List<Reclamo> todosLosReclamos() {
		return reclamoRepository.findAll();
	}

	public String generarReclamoVecino(String mail, Integer idSitio, Integer idDesperfecto, String descripcion,
			MultipartFile[] files) {
//		Aca tenemsos el documento
		Vecino vecino = vecinoservice.perfilVecinoregistrado(mail);
		if (vecino != null) {
			// Validamos el sitio
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {
				// Validamos desperfecto
				Desperfecto desperfecto = desperfectoService.buscarDesperfectoId(idDesperfecto);
				if (desperfecto != null) {
					Reclamo nuevoReclamo = new Reclamo(descripcion, null, vecino, desperfecto, sitio);

					reclamoRepository.save(nuevoReclamo);
					Reclamo r = ultimoReclamo();
					guardarImagenes.handleFileUpload(r.getIdReclamo(), files);

					return "Reclamo generado con exito";

				} else {
					return "Desperfecto no encontrado";
				}

			} else {
				return "Sitio no encontrado";
			}
		} else {
			return "Vecino no encontrado";
		}
	}
	public String generarReclamoVecino(int legajo, Integer idSitio, Integer idDesperfecto, String descripcion,
			MultipartFile[] files) {
//		Aca tenemsos el documento
		Personal inspector = personalService.perfilInspector(legajo);
		if (inspector != null) {
			// Validamos el sitio
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {
				// Validamos desperfecto
				Desperfecto desperfecto = desperfectoService.buscarDesperfectoId(idDesperfecto);
				if (desperfecto != null) {
					Reclamo nuevoReclamo = new Reclamo(descripcion, inspector, null, desperfecto, sitio);

					reclamoRepository.save(nuevoReclamo);

					Reclamo r = ultimoReclamo();
					guardarImagenes.handleFileUpload(r.getIdReclamo(), files);

					return "Reclamo generado con exito";

				} else {
					return "Desperfecto no encontrado";
				}

			} else {
				return "Sitio no encontrado";
			}
		} else {
			return "Inspector no encontrado";
		}
	}

	public Reclamo ultimoReclamo() {
		List<Reclamo> reclamos = reclamoRepository.findAll();
		Reclamo reclamo = null;
		for (Reclamo r : reclamos) {
			reclamo = r;
		}
		return reclamo;
	}

	public List<Reclamo> misReclamosVecino(String mail) {
		Vecino vecino = vecinoservice.perfilVecinoregistrado(mail);
		return vecino.getReclamos() ;
	}

	public List<MovimientoReclamo> movimientosReclamo(Integer idReclamo) {
		Reclamo reclamo=reclamoRepository.findByidReclamo(idReclamo);
		return movimientoReclamoRepository.findByReclamo(reclamo);
	}

}
