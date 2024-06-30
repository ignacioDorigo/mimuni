package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "desperfectos")
public class Desperfecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDesperfecto;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "idRubro", referencedColumnName = "idRubro", nullable = false)
	private Rubro rubro;
    @OneToMany(mappedBy = "desperfecto")
    private List<Reclamo> reclamos;
    
    public Desperfecto() {
    	
    }
	@Override
	public String toString() {
		return "Desperfecto [idDesperfecto=" + idDesperfecto + ", descripcion=" + descripcion + ", rubro=" + rubro
				+ ", reclamos=" + reclamos + "]";
	}
	public Desperfecto(Integer idDesperfecto, String descripcion, Rubro rubro, List<Reclamo> reclamos) {
		super();
		this.idDesperfecto = idDesperfecto;
		this.descripcion = descripcion;
		this.rubro = rubro;
		this.reclamos = reclamos;
	}
	public Integer getIdDesperfecto() {
		return idDesperfecto;
	}
	public void setIdDesperfecto(Integer idDesperfecto) {
		this.idDesperfecto = idDesperfecto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public List<Reclamo> getReclamos() {
		return reclamos;
	}
	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}
}
