package com.visa.proyectos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	@GeneratedValue
	private Integer id;	
	private String nombre;
	
	
	/**
	 * @param nombre
	 */
	public Status(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	/**
	 * 
	 */
	public Status() {
		super();
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

	@Override
	public String toString() {
		return  nombre;
	}
	
}
