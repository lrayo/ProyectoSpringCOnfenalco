package com.fundacion.proyecto.pm.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.proyecto.pm.model.entity.Depto;

@Repository
public interface DeptoRepository extends CrudRepository<Depto, Long> {

}
