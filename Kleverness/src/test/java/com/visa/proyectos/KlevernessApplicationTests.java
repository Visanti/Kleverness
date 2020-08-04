package com.visa.proyectos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.visa.proyectos.model.Status;
import com.visa.proyectos.repository.StatusRepository;

@SpringBootTest
class KlevernessApplicationTests {
	@Autowired
	StatusRepository  statusRepo;
	@Test
	void status1() {
		Status status1= new Status("Assigned");
		Status status2= new Status("Unassigned");
		Status status3= new Status("Revoked");
		
		statusRepo.save(status1);
		statusRepo.save(status2);
		statusRepo.save(status3);
		
	}

}
