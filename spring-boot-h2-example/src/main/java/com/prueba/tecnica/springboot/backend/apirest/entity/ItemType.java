package com.prueba.tecnica.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "itemTypes") 
public class ItemType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_type")
	private Long idItemType;
	
	
	@Column(name = "item_type")
	private String itemType;


	public ItemType() {
	
	}

	public Long getIdItemType() {
		return idItemType;
	}

	public void setIdItemType(Long idItemType) {
		this.idItemType = idItemType;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}



	private static final long serialVersionUID = 1L;
	
}
