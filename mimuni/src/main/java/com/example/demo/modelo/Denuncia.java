package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "denuncias")
public class Denuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDenuncias")
	private Integer idDenuncia;
	private String descripcion;
	private String estado;
	private int  aceptaResonsabilidad;
	@ManyToOne
	@JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
	private Vecino vecino;
	@ManyToOne
	@JoinColumn(name = "idSitio", referencedColumnName = "idSitio", nullable = false)
	private Sitio sitio;
	@OneToMany(mappedBy = "denuncia")
	 private List<MovimientoDenuncia> movimientosDenuncia;
	public Integer getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(Integer idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getAceptaResonsabilidad() {
		return aceptaResonsabilidad;
	}
	public void setAceptaResonsabilidad(int aceptaResonsabilidad) {
		this.aceptaResonsabilidad = aceptaResonsabilidad;
	}
	public Vecino getVecino() {
		return vecino;
	}
	public void setVecino(Vecino vecino) {
		this.vecino = vecino;
	}
	public Sitio getSitio() {
		return sitio;
	}
	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}
	public List<MovimientoDenuncia> getMovimientosDenuncia() {
		return movimientosDenuncia;
	}
	public void setMovimientosDenuncia(List<MovimientoDenuncia> movimientosDenuncia) {
		this.movimientosDenuncia = movimientosDenuncia;
	}
	@Override
	public String toString() {
		return "Denuncia [idDenuncia=" + idDenuncia + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", aceptaResonsabilidad=" + aceptaResonsabilidad + ", vecino=" + vecino + ", sitio=" + sitio
				+ ", movimientosDenuncia=" + movimientosDenuncia + "]";
	}
	public Denuncia(Integer idDenuncia, String descripcion, String estado, int aceptaResonsabilidad, Vecino vecino,
			Sitio sitio, List<MovimientoDenuncia> movimientosDenuncia) {
		super();
		this.idDenuncia = idDenuncia;
		this.descripcion = descripcion;
		this.estado = estado;
		this.aceptaResonsabilidad = aceptaResonsabilidad;
		this.vecino = vecino;
		this.sitio = sitio;
		this.movimientosDenuncia = movimientosDenuncia;
	}
	
	public Denuncia() {
		
	}
}
