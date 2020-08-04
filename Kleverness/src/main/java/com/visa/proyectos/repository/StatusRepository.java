package com.visa.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.proyectos.model.Status;


public interface StatusRepository extends JpaRepository<Status, Integer> {

}
