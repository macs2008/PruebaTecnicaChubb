package com.prueba.tecnica.springboot.backend.apirest.dao;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


import com.prueba.tecnica.springboot.backend.apirest.entity.ItemType;


public interface IITemType extends CrudRepository<ItemType, Long> {

	
	@Query(value = "SELECT c FROM ItemType c" , nativeQuery = false)
	List<ItemType> consultarItemType();
}
