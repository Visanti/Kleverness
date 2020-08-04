package com.visa.proyectos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.visa.proyectos.security.model.Usuario;
import com.visa.proyectos.security.repository.UsuarioRepo;

@SpringBootTest
public class UsuarioTest {

	@Autowired
	UsuarioRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Test
	public void testUsuariosRepo() {
		Usuario us = new Usuario();
		us.setUsername("prueba");
		//Encriptar contraseña
		us.setPassword(encoder.encode("12345"));
		
		Usuario saveUs = userRepo.save(us);
		
		assertTrue(us.getUsername().equalsIgnoreCase(saveUs.getUsername()));
	}
}
