package com.prueba.tecnica.springboot.backend.apirest.entity;

import java.io.Serializable;

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
@Table(name = "stock")
public class Stock implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStrock;
	
	@Column(name = "cantidad_amount")
	private Integer cantidaAmount;
	
	@Column(name = "inventory_Code")
	private String inventoryCode;
	
	@Column(name = "amount_stock")
	private Integer amountStock;
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item_type", referencedColumnName = "id_item_type")
	private ItemType itemType;

	public Long getIdStrock() {
		return idStrock;
	}


	public void setIdStrock(Long idStrock) {
		this.idStrock = idStrock;
	}


	public Integer getCantidaAmount() {
		return cantidaAmount;
	}

	public void setCantidaAmount(Integer cantidaAmount) {
		this.cantidaAmount = cantidaAmount;
	}


	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}


	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}


	public Integer getAmountStock() {
		return amountStock;
	}


	public void setAmountStock(Integer amountStock) {
		this.amountStock = amountStock;
	}


	private static final long serialVersionUID = 1L;

}
