package com.prueba.tecnica.springboot.backend.apirest.enums;

public enum EnumPruebaTecnica {
	CONSULTA_EXITOSA("001", "CONSULTA EXITOSA"),
	ITEM_TYPE__OBLIGATORIO("002", "EL DATO ITEM TYPE ES OBLIGATORIO"),
	ITEM_TYPE_NUMERICO("003", "EL DATO ITEM TYPE DEBE SER NUMERICO"),
	ITEM_NO__OBLIGATORIO("004", "EL DATO ITEM NO ES OBLIGATORIO"),
	ITEM_NO_NUMERICO("005", "EL DATO ITEM NO DEBE SER NUMERICO"),
	NAME__OBLIGATORIO("006", "EL DATO NAME ES OBLIGATORIO"),
	CANTIDAD_AMOUNT_NUMERICO("007", "EL DATO CANTIDAD AMOUNT DEBE SER NUMERICO"),
	CANTIDAD_AMOUNT__OBLIGATORIO("008", "EL DATO CANTIDAD AMOUNT ES OBLIGATORIO"),
	INVENTORY_CODE__OBLIGATORIO("009", "EL DATO INVETORY CODE ES OBLIGATORIO"),
	NO_EXISTEN_REGISTROS("010", "NO EXISTEN REGISTROS"),
	;
	
	
	private final String codigoClase;
	private final String descripcionClase;
	
	private EnumPruebaTecnica(String codigoClase, String descripcionClase) {
		this.codigoClase = codigoClase;
		this.descripcionClase = descripcionClase;
	}
	
	
	
	public String getCodigoClase() {
		return codigoClase;
	}



	public String getDescripcionClase() {
		return descripcionClase;
	}
}
