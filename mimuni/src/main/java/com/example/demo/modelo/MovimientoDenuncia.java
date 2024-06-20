package com.example.demo.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientosdenuncia")
public class MovimientoDenuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	private String responsable;
	private String causa;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "idDenuncia", referencedColumnName = "idDenuncia", nullable = false)
	private Denuncia denuncia;
	
	
	public MovimientoDenuncia() {
		
	}
	public MovimientoDenuncia(Integer idMovimiento, String responsable, String causa, Date fecha, Denuncia denuncia) {
		super();
		this.idMovimiento = idMovimiento;
		this.responsable = responsable;
		this.causa = causa;
		this.fecha = fecha;
		this.denuncia = denuncia;
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
	public Denuncia getDenuncia() {
		return denuncia;
	}
	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}
	@Override
	public String toString() {
		return "MovimientoDenuncia [idMovimiento=" + idMovimiento + ", responsable=" + responsable + ", causa=" + causa
				+ ", fecha=" + fecha + ", denuncia=" + denuncia + "]";
	}
	
	
	
}
