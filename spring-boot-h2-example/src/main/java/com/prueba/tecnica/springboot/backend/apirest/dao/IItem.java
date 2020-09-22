package com.prueba.tecnica.springboot.backend.apirest.dao;


import org.springframework.data.repository.CrudRepository;

import com.prueba.tecnica.springboot.backend.apirest.entity.Item;


public interface IItem  extends CrudRepository<Item, Long>{

	
	
}
