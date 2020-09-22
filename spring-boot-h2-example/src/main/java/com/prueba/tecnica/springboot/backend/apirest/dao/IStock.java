package com.prueba.tecnica.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.tecnica.springboot.backend.apirest.entity.Stock;


public interface IStock extends CrudRepository<Stock, Long>{

}
