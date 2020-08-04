package com.visa.proyectos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.visa.proyectos.model.Dispositivos;
import com.visa.proyectos.model.Status;
import com.visa.proyectos.repository.DispositivosRepository;
import com.visa.proyectos.repository.StatusRepository;
import com.visa.proyectos.service.DispositivosService;

import dto.RequestDispositivos;

@SpringBootTest
public class DispositivosTest {
	@Autowired
	StatusRepository statusRepo;

	@Autowired
	DispositivosService dispositivosService;
	private static final String tipo = "Dispositivo";

	@Test
	void dispositivosLoad() {
		Dispositivos dispositivo = new Dispositivos();
		dispositivo.setMacAddress("4568");
		dispositivo.setType(tipo);
		Status status = statusRepo.findById(1).orElse(null);
		dispositivo.setStatus(status);
		String result = this.dispositivosService.saveDispositivo(dispositivo);
	}

}
