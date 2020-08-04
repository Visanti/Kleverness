package com.visa.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.proyectos.model.Dispositivos;

public interface DispositivosRepository  extends JpaRepository<Dispositivos, Integer>{
	//Usuarios findByNombre(String nombre);
	Dispositivos findByMacAddress(String macAddress);
}
