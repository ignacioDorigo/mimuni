package com.example.demo.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer legajo;
	
	
	private String nombre;
	private String documento;
	private String password;
	private Rubro rubro;
	private Integer categoria;
	
	
	@Column(name = "fechaingreso")
	private Date fechaIngreso;

	public Personal() {

	}

	public Personal(Integer legajo, String nombre, String documento, String password, Rubro rubro, Integer categoria,
			Date fechaIngreso) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.documento = documento;
		this.password = password;
		this.rubro = rubro;
		this.categoria = categoria;
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Personal [legajo=" + legajo + ", nombre=" + nombre + ", documento=" + documento + ", password="
				+ password + ", rubro=" + rubro + ", categoria=" + categoria + ", fechaIngreso=" + fechaIngreso + "]";
	}

	

}
