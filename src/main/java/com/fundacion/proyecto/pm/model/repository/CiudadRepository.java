package com.fundacion.proyecto.pm.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundacion.proyecto.pm.model.entity.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

	
	//Buscar ciudad por deptos
	
	List<Ciudad> findBydeptoId(Long idDepto);
}
