package com.fundacion.proyecto.pm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.proyecto.pm.model.entity.Ciudad;
import com.fundacion.proyecto.pm.model.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements iCiudadService {
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	

	@Override
	public List<Ciudad> listaCiudades() {

		return (List<Ciudad>) ciudadRepository.findAll();
	}



	@Override
	public List<Ciudad> buscarPorIdDepto(Long idDepto) {
		
		return ciudadRepository.findBydeptoId(idDepto);
	}

}
