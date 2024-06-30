package com.example.demo.modelo;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class Reclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReclamo;
	private String descripcion;
	private String estado;
	private Integer IdReclamoUnificado;
	@ManyToOne
	@JoinColumn(name = "legajo", referencedColumnName = "legajo", nullable = true)
	private Personal personal;
	@ManyToOne
	@JoinColumn(name = "documento", referencedColumnName = "documento", nullable = true)
	private Vecino vecino;
	@ManyToOne
	@JoinColumn(name = "idDesperfecto", referencedColumnName = "idDesperfecto", nullable = false)
	private Desperfecto desperfecto;
	@OneToMany(mappedBy = "reclamo")
	 private List<MovimientoReclamo> movimientosReclamo;
	
	
	

	public List<MovimientoReclamo> getMovimientosReclamo() {
		return movimientosReclamo;
	}
	public void setMovimientosReclamo(List<MovimientoReclamo> movimientosReclamo) {
		this.movimientosReclamo = movimientosReclamo;
	}

	
	public Reclamo() {
	}
	
	@Override
	public String toString() {
		return "Reclamo [idReclamo=" + idReclamo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", IdReclamoUnificado=" + IdReclamoUnificado + ", personal=" + personal + ", vecino=" + vecino
				+ ", desperfecto=" + desperfecto + ", movimientosReclamo=" + movimientosReclamo + ", sitio=" + sitio
				+ "]";
	}
	public Reclamo( String descripcion, Personal personal,
			Vecino vecino, Desperfecto desperfecto, Sitio sitio) {
		super();
		this.descripcion = descripcion;
		this.estado = "iniciado";
		this.personal = personal;
		this.vecino = vecino;
		this.desperfecto = desperfecto;
		this.sitio = sitio;
		this.movimientosReclamo =new ArrayList<>();
	}
	public Integer getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
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
	public Integer getIdReclamoUnificado() {
		return IdReclamoUnificado;
	}
	public void setIdReclamoUnificado(Integer idReclamoUnificado) {
		IdReclamoUnificado = idReclamoUnificado;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Vecino getVecino() {
		return vecino;
	}
	public void setVecino(Vecino vecino) {
		this.vecino = vecino;
	}
	public Desperfecto getDesperfecto() {
		return desperfecto;
	}
	public void setDesperfecto(Desperfecto desperfecto) {
		this.desperfecto = desperfecto;
	}
	public Sitio getSitio() {
		return sitio;
	}
	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}
	@ManyToOne
	@JoinColumn(name = "idSitio", referencedColumnName = "idSitio", nullable = false)
	private Sitio sitio;
}
