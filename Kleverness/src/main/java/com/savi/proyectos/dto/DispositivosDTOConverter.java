package com.savi.proyectos.dto;



import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.savi.proyectos.model.Dispositivos;


@Component
public class DispositivosDTOConverter {
private final ModelMapper modelMapper = new ModelMapper();
	
	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<Dispositivos, DispositivosDTO>() {

			@Override
			protected void configure() {
				map().setStatus(source.getStatus().getNombre());
			}
		});
	}
	
	public DispositivosDTO convertToDto(Dispositivos dispositivo) {
		return modelMapper.map(dispositivo, DispositivosDTO.class);
		
	}
}


