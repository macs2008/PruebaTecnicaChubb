package com.prueba.tecnica.springboot.backend.apirest.wsdto.local;

import java.io.Serializable;
import java.util.List;

public class ResponseConsultaItemTypeWsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private List<DetalleItemTypeWsDto> detalleItemTypeWsDto;
	
	
	public ResponseConsultaItemTypeWsDto() {
		
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

	public List<DetalleItemTypeWsDto> getDetalleItemTypeWsDto() {
		return detalleItemTypeWsDto;
	}

	public void setDetalleItemTypeWsDto(List<DetalleItemTypeWsDto> detalleItemTypeWsDto) {
		this.detalleItemTypeWsDto = detalleItemTypeWsDto;
	}
	
}
