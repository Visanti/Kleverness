package com.savi.proyectos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.savi.proyectos.model.Status;



public interface StatusRepository extends JpaRepository<Status, Integer> {

}
