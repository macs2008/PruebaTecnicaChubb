package com.prueba.tecnica.springboot.backend.apirest.wsdto.local;

import java.io.Serializable;

public class ResponseRegistroInicialItemTypeWsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	
	public ResponseRegistroInicialItemTypeWsDto() {
		
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
}
