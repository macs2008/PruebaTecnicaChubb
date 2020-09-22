package com.prueba.tecnica.springboot.backend.apirest.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long idItem;
	
	@Column(name = "item_no")
	private Integer itemNo;
	
	
	@Column(name = "name")
	private String name;
	

	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item_type", referencedColumnName = "id_item_type")
	private ItemType itemType;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_id")
	private Stock stock; 
	*/
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}


	public Integer getItemNo() {
		return itemNo;
	}


	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	/*
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

*/

	private static final long serialVersionUID = 1L;
	
}