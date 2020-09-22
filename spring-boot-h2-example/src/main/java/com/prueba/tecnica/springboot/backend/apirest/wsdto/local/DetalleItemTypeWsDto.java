package com.prueba.tecnica.springboot.backend.apirest.wsdto.local;

import java.io.Serializable;

public class DetalleItemTypeWsDto implements Serializable {

	private String idItemType;
	private String itemType;

	
	
	public DetalleItemTypeWsDto() {
	
	}

	public String getIdItemType() {
		return idItemType;
	}

	public void setIdItemType(String idItemType) {
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
