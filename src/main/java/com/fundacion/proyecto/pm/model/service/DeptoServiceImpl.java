package com.fundacion.proyecto.pm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.proyecto.pm.model.entity.Depto;
import com.fundacion.proyecto.pm.model.repository.DeptoRepository;

@Service
public class DeptoServiceImpl implements IDeptoService{

	@Autowired
	private DeptoRepository deptoRepository;
	
	@Override
	public List<Depto> listarDeptos() {
		
		return (List<Depto>) deptoRepository.findAll();
	}

}
