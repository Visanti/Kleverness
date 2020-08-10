package com.savi.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savi.proyectos.model.Dispositivos;

public interface DispositivosRepository  extends JpaRepository<Dispositivos, Integer>{
	Dispositivos findByMacAddress(String macAddress);
}
