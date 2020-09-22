package com.prueba.tecnica.springboot.backend.apirest.wsdto.local;

import java.io.Serializable;

public class RequestRegistroinicalItemTypeWsDto implements Serializable {


	private static final long serialVersionUID = 1L; 
	
	private String itemType;	
	private String itemNo;
	private String name;
	private String cantidaAmount;
	private String inventoryCode;
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCantidaAmount() {
		return cantidaAmount;
	}

	public void setCantidaAmount(String cantidaAmount) {
		this.cantidaAmount = cantidaAmount;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

}
