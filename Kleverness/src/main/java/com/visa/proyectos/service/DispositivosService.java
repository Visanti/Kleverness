package com.visa.proyectos.service;

import java.util.List;

import com.visa.proyectos.model.Dispositivos;

import dto.DispositivosDTO;
import dto.RequestDispositivos;

public interface DispositivosService {

	public List<Dispositivos> getDispositivos();

	public Dispositivos obtenerDispositivo(String id);

	public String saveDispositivo(Dispositivos parametros);

}
