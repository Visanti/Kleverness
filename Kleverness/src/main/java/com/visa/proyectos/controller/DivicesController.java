package com.visa.proyectos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.visa.proyectos.model.Dispositivos;
import com.visa.proyectos.model.Status;
import com.visa.proyectos.repository.StatusRepository;
import com.visa.proyectos.service.DispositivosService;

import dto.DispositivosDTO;
import dto.DispositivosDTOConverter;
import dto.RequestDispositivos;

@RestController
@RequestMapping("/api/v1/WS")
public class DivicesController {
	private static final Logger logger = LoggerFactory.getLogger(DivicesController.class);
	private final DispositivosDTOConverter dispositivosDTOConverter = new DispositivosDTOConverter();
	private static final String tipo = "Dispositivo";
	@Autowired
	DispositivosService dispositivosService;
	@Autowired
	StatusRepository statusRepo;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o más
	 */
	@GetMapping("/divices")
	public ResponseEntity<?> obtenerTodos() {
		List<Dispositivos> result = dispositivosService.getDispositivos();
		if (result.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay divices registrados");
		} else {

			List<DispositivosDTO> dtoList = result.stream().map(dispositivosDTOConverter::convertToDto)
					.collect(Collectors.toList());

			return ResponseEntity.ok(dtoList);
		}

	}

	@GetMapping("/divices/{macAddress}")
	public ResponseEntity<Dispositivos> obtenerUno(@PathVariable String macAddress) {

		Dispositivos result = dispositivosService.obtenerDispositivo(macAddress);

		if (result == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay divices registrados");
		} else {
			return ResponseEntity.ok(result);
		}

	}

	@PostMapping(value = "/divices", headers = "Accept=application/json")
	public ResponseEntity<?> insertarDispositivo(@RequestBody RequestDispositivos parametros) {

		Dispositivos dispositivo = new Dispositivos();
		dispositivo.setMacAddress(parametros.getMacAddress());
		dispositivo.setType(tipo);
		Status status = statusRepo.findById(parametros.getStatus()).orElse(null);
		dispositivo.setStatus(status);
		String result = this.dispositivosService.saveDispositivo(dispositivo);

		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se registro el divice");
		}

	}

}
