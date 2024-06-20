package com.example.demo.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientosreclamo")
public class MovimientoReclamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	private String responsable;
	private String causa;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "idReclamo", referencedColumnName = "idReclamo", nullable = false)
	private Reclamo reclamo;
	
	public MovimientoReclamo() {
		
	}
	
	public MovimientoReclamo(Integer idMovimiento, String responsable, String causa, Date fecha, Reclamo reclamo) {
		super();
		this.idMovimiento = idMovimiento;
		this.responsable = responsable;
		this.causa = causa;
		this.fecha = fecha;
		this.reclamo = reclamo;
	}


	@Override
	public String toString() {
		return "MovimientoReclamo [idMovimiento=" + idMovimiento + ", responsable=" + responsable + ", causa=" + causa
				+ ", fecha=" + fecha + ", reclamo=" + reclamo + "]";
	}


	public Integer getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public String getResponsable() {
		return responsable;
	}


	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	public String getCausa() {
		return causa;
	}


	public void setCausa(String causa) {
		this.causa = causa;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Reclamo getReclamo() {
		return reclamo;
	}


	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}
	
	
	
}
