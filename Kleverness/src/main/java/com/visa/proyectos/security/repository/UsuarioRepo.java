package com.visa.proyectos.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.proyectos.security.model.Usuario;



public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	Usuario findByUsername(String username);

}
