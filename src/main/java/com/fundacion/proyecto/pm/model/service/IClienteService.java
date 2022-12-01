package com.fundacion.proyecto.pm.model.service;

import java.util.List;

import com.fundacion.proyecto.pm.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> listarTodos();
	
	public void guardar(Cliente cliente);
	
	public Cliente buscarPorId(Long id);
	
	public void eliminar(Long id);

}
