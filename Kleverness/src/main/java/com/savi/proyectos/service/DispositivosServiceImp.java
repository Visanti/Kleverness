package com.savi.proyectos.service;



import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savi.proyectos.model.Dispositivos;
import com.savi.proyectos.repository.DispositivosRepository;



@Service
public class DispositivosServiceImp implements DispositivosService {
	private static final Logger logger = LoggerFactory.getLogger(DispositivosServiceImp.class);
	@Autowired
	DispositivosRepository dispositivosRepo;

	@Override
	public List<Dispositivos> getDispositivos() {

		return dispositivosRepo.findAll();
	}

	@Override
	public Dispositivos obtenerDispositivo(String id) {
		// TODO Auto-generated method stub
		return dispositivosRepo.findByMacAddress(id);
	}

	@Override
	public String saveDispositivo(Dispositivos parametros) {
		Dispositivos hubs = new Dispositivos();
		hubs.setMacAddress(parametros.getMacAddress());
		hubs.setQrCode(qrCode(parametros.getType()));
		hubs.setType(parametros.getType());
		hubs.setStatus(parametros.getStatus());

		Dispositivos response = dispositivosRepo.save(hubs);
		return response.getQrCode();
	}

	public static String qrCode(String tipo) {
		SecureRandom se = new SecureRandom();
		String text;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "1234567890";
		Random r = new Random();

		if (tipo.equals("Dispositivo")) {
			text = "D2";
		} else {
			text = "H1";
		}
		for (int i = 0; i < 2; i++) {
			text += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		for (int i = 0; i < 3; i++) {
			text += alphabet2.charAt(r.nextInt(alphabet2.length()));
		}
		for (int i = 0; i < 4; i++) {
			text += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		text += alphabet2.charAt(r.nextInt(alphabet2.length()));

		return text;

	}

}
