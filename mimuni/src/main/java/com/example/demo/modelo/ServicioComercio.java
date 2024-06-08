	package com.example.demo.modelo;
	
	import java.util.List;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "servicioscomercios")
	public class ServicioComercio {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idserviciocomercio")
		private Integer idServicioComercio;
	
		@Column(name = "direccion")
		private String direccion;
		
		
		@Column(name = "contacto")
		private String contacto;
		
		@Column(name = "descripcion")
		private String descripcion;
	
		@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "documento", referencedColumnName = "documento")
		private Vecinoregistrado vecino;
	
		public ServicioComercio() {
	
		}
	
		public ServicioComercio(String direccion, String contacto, String descripcion,
				Vecinoregistrado vecino) {
			super();
			this.idServicioComercio = 00;
			this.direccion = direccion;
			this.contacto = contacto;
			this.descripcion = descripcion;
			this.vecino = vecino;
		}
	
		public Integer getIdServicioComercio() {
			return idServicioComercio;
		}
	
		public void setIdServicioComercio(Integer idServicioComercio) {
			this.idServicioComercio = idServicioComercio;
		}
	
		public String getDireccion() {
			return direccion;
		}
	
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
	
		public String getContacto() {
			return contacto;
		}
	
		public void setContacto(String contacto) {
			this.contacto = contacto;
		}
	
		public String getDescripcion() {
			return descripcion;
		}
	
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	
		public Vecinoregistrado getVecino() {
			return vecino;
		}
	
		public void setVecino(Vecinoregistrado vecino) {
			this.vecino = vecino;
		}
	
		@Override
		public String toString() {
			return "ServicioComercio [idServicioComercio=" + idServicioComercio + ", direccion=" + direccion + ", contacto="
					+ contacto + ", descripcion=" + descripcion + ", vecino=" + vecino + "]";
		}
	
	}
