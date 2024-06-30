package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rubros")
public class Rubro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRubro;
	private String descripcion;
	public Rubro() {
		
	}
	public Rubro(Integer idRubro, String descripcionl) {
		super();
		this.idRubro = idRubro;
		this.descripcion = descripcion;

	}
	@Override
	public String toString() {
		return "Rubro [idRubro=" + idRubro + ", descripcion=" + descripcion  + "]";
	}
	public Integer getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
