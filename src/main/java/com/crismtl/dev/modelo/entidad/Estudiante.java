package com.crismtl.dev.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Basic
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Basic
	@Column(name = "apellido", length = 100)
	private String apellido;
	
	@Basic
	@Column(name = "fecha_de_nacimiento")
	private Date fechaDeNacimiento;
	
	@Override
	public String toString() {
		return "id: " + id + "\tnombre: " + nombre + "\tapellido: " + apellido + "\tfecha de nacimiento: " + fechaDeNacimiento;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Estudiante est = (Estudiante) o;
		
		if((id != null) ? (!id.equals(est.id)) : (est.id != null)) return false;
		if(nombre != null ? !nombre.equals(est.nombre) : est.nombre != null) return false;
		if(apellido != null ? !apellido.equals(est.apellido) : est.apellido != null) return false;
		if(fechaDeNacimiento != null ? !fechaDeNacimiento.equals(est.fechaDeNacimiento) : est.fechaDeNacimiento != null) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int resultado = (id != null) ? id.hashCode() : 0;
		resultado = 31 * resultado + (nombre != null ? nombre.hashCode() : 0);
		resultado = 31 * resultado + (apellido != null ? apellido.hashCode() : 0);
		resultado = 31 * resultado + (fechaDeNacimiento != null ? fechaDeNacimiento.hashCode() : 0);
		return resultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
}
