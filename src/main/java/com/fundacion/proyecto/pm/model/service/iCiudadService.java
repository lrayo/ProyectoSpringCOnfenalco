package com.fundacion.proyecto.pm.model.service;

import java.util.List;

import com.fundacion.proyecto.pm.model.entity.Ciudad;

public interface iCiudadService {
	
	
	List<Ciudad> listaCiudades();
	
	List<Ciudad> buscarPorIdDepto(Long idDepto);

}
