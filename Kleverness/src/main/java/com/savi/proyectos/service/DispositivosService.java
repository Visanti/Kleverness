package com.savi.proyectos.service;

import java.util.List;

import com.savi.proyectos.model.Dispositivos;

public interface DispositivosService {
	
	public List<Dispositivos> getDispositivos();

	public Dispositivos obtenerDispositivo(String id);

	public String saveDispositivo(Dispositivos parametros);

}
