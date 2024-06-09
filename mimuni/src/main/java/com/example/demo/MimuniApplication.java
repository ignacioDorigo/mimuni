package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Barrio;
import com.example.demo.modelo.Personal;
import com.example.demo.modelo.ServicioComercio;
import com.example.demo.modelo.ServicioProfesional;
import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.*;
import com.example.demo.service.PersonalService;

@SpringBootApplication
public class MimuniApplication implements CommandLineRunner {
	// Repositorios
	@Autowired
	BarrioRepository repobarrio;

	@Autowired
	VecinoRepository repovecino;

	@Autowired
	VecinoregistradoRepository repovecinoregistrado;

	@Autowired
	PersonalRepository repopersonal;

	// Services
	@Autowired
	PersonalService personalservice;

	@Autowired
	ServicioComerciorRepository servicio;

	@Autowired
	ServicioProfesionalRepository servicioProfesional;
	
	@Autowired
	EmailSenderService emailSender;

	public static void main(String[] args) {
		SpringApplication.run(MimuniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		mostrarBarrios();
//		mostrarVecinos();
//		register("DNI28000429", "ignaciodorigo@nacho0305sadasd.com.ar");
//		mostrarVecinosRegistrados();
//		mostrarPersonal();
//		System.out.println(personalservice.cambiarPassword(1, "password", "alpachiri", "alpachiri"));
//		agregarServicio();
		
//		eliminarServicio();

//		mostrarServiciosComercio();
//		mostrarServiciosComerciosHabilitados();
//		crearServicioProfesional();
//		mostrarServiciosProfesionales();
		System.out.println(olvideContrasenia("sack@gmail.com"));

//		eliminarServicioProfesional(1);
	}
	
	public String olvideContrasenia(String mail) {
		List<Vecinoregistrado> vecinosConEseMail = repovecinoregistrado.findByMail(mail);
		Vecinoregistrado vecino = null;
		for (Vecinoregistrado v : vecinosConEseMail) {
			vecino = v;
		}
		if (vecino == null) {
			return "No estas registrado";
		} else {
			emailSender.sendEmail("ignaciodorigo@gmail.com", "Contrasenia enviada",
					"Tu contrasenia es " + vecino.getContrasenia());
			return "Correo enviado correctamente";
		}
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
		for (Personal inspector : inspectores) {
			System.out.println(inspector);
		}
	}

	public void mostrarServiciosComercio() {
		List<ServicioComercio> servicios = servicio.findAll();
		for (ServicioComercio servicio : servicios) {
			System.out.println(servicio);
		}
	}

	public void agregarServicio() {
//		Hay que hacer la verificacion qde que ya este logueado//
		Optional<Vecinoregistrado> vecinoOptional = repovecinoregistrado.findById("DNI28000429");
		Vecinoregistrado vecino = vecinoOptional.get();
		ServicioComercio servicioNuevo = new ServicioComercio("Avenida Cordoba 234", "1124023223",
				"Vendemos empanadas pizzitas y panchitos", vecino, "B");
		servicio.save(servicioNuevo);
	}

// HAY QUE HACER MEJOR 
	public void eliminarServicio() {
		Optional<ServicioComercio> servicioOptional = servicio.findById(3);
		if (servicioOptional.isPresent()) {
			System.out.println("Entre en el IF");
			servicio.deleteById(3);
		} else {
			System.out.println("NO EXISTE ESE REGISTRO");
		}
	}

	public void mostrarServiciosComerciosHabilitados() {
		List<ServicioComercio> servicios = servicio.findByEstado("H");
		for (ServicioComercio servicio : servicios) {
			System.out.println(servicio);
		}
	}
	
//Modificarrrrr
	public void crearServicioProfesional() {
//		Hay que hacer la verificacion qde que ya este logueado//
		Optional<Vecinoregistrado> vecinoOptional = repovecinoregistrado.findById("DNI28000429");
		Vecinoregistrado vecino = vecinoOptional.get();
		Optional<Vecino> vecOp = repovecino.findById(vecino.getDocumento());
		Vecino vec = vecOp.get();
		ServicioProfesional servicio = new ServicioProfesional(vec.getNombre(), vec.getApellido(), "11240223",
				"16 a 20hs", "Comida", "Hacemos un rico asado", vecino, "B");
		servicioProfesional.save(servicio);
	}

	public void mostrarServiciosProfesionales() {
		System.out.println("   SERVICIOS    PROFESIONALES     ");
		List<ServicioProfesional> servicios = servicioProfesional.findAll();
		for (ServicioProfesional servicio : servicios) {
			System.out.println(servicio);
		}
	}
	
	public void eliminarServicioProfesional(Integer id) {
		servicioProfesional.deleteById(id);
	}

}
