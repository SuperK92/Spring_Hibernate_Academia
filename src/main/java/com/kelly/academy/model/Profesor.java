package com.kelly.academy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@Column(name="id_profesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="dni_profesor")
	private String dni;
	
	@Column(name="nombre_profesor")
	private String nombre;
	
	@Column(name="apellidos_profesor")
	private String apellidos;
	
	@Column(name="direccion_profesor")
	private String direccion;
	
	@Column(name="email_profesor")
	private String email;
	
	@Column(name="telefono_profesor")
	private String telefono;
	
	@OneToMany(mappedBy="profesor", cascade = CascadeType.ALL)
	private Set<Curso> cursos = new HashSet<Curso>(0);;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + "]";
	}


}
