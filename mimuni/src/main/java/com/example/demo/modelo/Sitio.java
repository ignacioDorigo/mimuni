package com.example.demo.modelo;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sitios")
public class Sitio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSitio;
	private double latitud;
	private double longitud;
	private String calle;
	private int numero;
	private String entreCalleA;
	private String entreCalleB;
	private String descripcion;
	private String aCargoDe;
	private Date apertura;
	private Date cierre;
	private List<String> comentarios;
	@OneToMany(mappedBy = "Sitio")
	private List<Denuncia> denuncia;
	
	public Sitio() {
		
	}
	public Sitio(Integer idSitio, double latitud, double longitud, String calle, int numero, String entreCalleA,
			String entreCalleB, String descripcion, String aCargoDe, Date apertura, Date cierre,
			List<String> comentarios, List<Denuncia> denuncia) {
		super();
		this.idSitio = idSitio;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calle = calle;
		this.numero = numero;
		this.entreCalleA = entreCalleA;
		this.entreCalleB = entreCalleB;
		this.descripcion = descripcion;
		this.aCargoDe = aCargoDe;
		this.apertura = apertura;
		this.cierre = cierre;
		this.comentarios = comentarios;
		this.denuncia = denuncia;
	}
	@Override
	public String toString() {
		return "Sitio [idSitio=" + idSitio + ", latitud=" + latitud + ", longitud=" + longitud + ", calle=" + calle
				+ ", numero=" + numero + ", entreCalleA=" + entreCalleA + ", entreCalleB=" + entreCalleB
				+ ", descripcion=" + descripcion + ", aCargoDe=" + aCargoDe + ", apertura=" + apertura + ", cierre="
				+ cierre + ", comentarios=" + comentarios + ", denuncia=" + denuncia + "]";
	}
	public Integer getIdSitio() {
		return idSitio;
	}
	public void setIdSitio(Integer idSitio) {
		this.idSitio = idSitio;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEntreCalleA() {
		return entreCalleA;
	}
	public void setEntreCalleA(String entreCalleA) {
		this.entreCalleA = entreCalleA;
	}
	public String getEntreCalleB() {
		return entreCalleB;
	}
	public void setEntreCalleB(String entreCalleB) {
		this.entreCalleB = entreCalleB;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getaCargoDe() {
		return aCargoDe;
	}
	public void setaCargoDe(String aCargoDe) {
		this.aCargoDe = aCargoDe;
	}
	public Date getApertura() {
		return apertura;
	}
	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}
	public Date getCierre() {
		return cierre;
	}
	public void setCierre(Date cierre) {
		this.cierre = cierre;
	}
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Denuncia> getDenuncia() {
		return denuncia;
	}
	public void setDenuncia(List<Denuncia> denuncia) {
		this.denuncia = denuncia;
	}
	
	

}
