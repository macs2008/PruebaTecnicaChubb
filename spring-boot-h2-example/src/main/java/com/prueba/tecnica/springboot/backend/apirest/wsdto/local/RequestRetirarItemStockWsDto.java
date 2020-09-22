package com.prueba.tecnica.springboot.backend.apirest.wsdto.local;

import java.io.Serializable;

public class RequestRetirarItemStockWsDto implements Serializable {


	private static final long serialVersionUID = 1L; 
	
	private String idItemType;

	public String getIdItemType() {
		return idItemType;
	}

	public void setIdItemType(String idItemType) {
		this.idItemType = idItemType;
	}	
	

}
