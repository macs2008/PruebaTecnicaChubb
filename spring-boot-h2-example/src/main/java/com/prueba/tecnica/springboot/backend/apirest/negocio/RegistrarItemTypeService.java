package com.prueba.tecnica.springboot.backend.apirest.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.springboot.backend.apirest.servicio.utilidades.Utils;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRegistroinicalItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseRegistroInicialItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.enums.EnumPruebaTecnica;
import com.prueba.tecnica.springboot.backend.apirest.helper.RegistrarItemTypeHelper;

@Service
public class RegistrarItemTypeService {

	private final static Logger logger = Logger.getLogger(RegistrarItemTypeService.class.getName());
	
	private ResponseRegistroInicialItemTypeWsDto responseRegistroInicialItemType;
	
	
	@Autowired
	private RegistrarItemTypeHelper registrarItemTypeHelper;
	
	public ResponseRegistroInicialItemTypeWsDto registrarItemTypeService(RequestRegistroinicalItemTypeWsDto request) {
	
	responseRegistroInicialItemType = new ResponseRegistroInicialItemTypeWsDto();
	
	
	if(!validarDatosBeneficiarioConDiscapacidad(request)){
		return responseRegistroInicialItemType;
	}
	
	
	if(registrarItemTypeHelper.RegistrarItemTypeHelper(request, responseRegistroInicialItemType)) {
		responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getCodigoClase());
		responseRegistroInicialItemType.setDescripcionRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getDescripcionClase());
		return responseRegistroInicialItemType;
	}
	
	return responseRegistroInicialItemType;
}
	
	
	public boolean validarDatosBeneficiarioConDiscapacidad(RequestRegistroinicalItemTypeWsDto request) {
		
		
		if (request == null || Utils.esVacio(request.getItemType())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		if (!Utils.esNumerico(request.getItemType())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE_NUMERICO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE_NUMERICO.getDescripcionClase());
			return false;
		}
		
		if (Utils.esVacio(request.getItemNo())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_NO__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_NO__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		if (!Utils.esNumerico(request.getItemNo())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_NO_NUMERICO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_NO_NUMERICO.getDescripcionClase());
			return false;
		}
		
		if (Utils.esVacio(request.getName())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.NAME__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.NAME__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		if (Utils.esVacio(request.getCantidaAmount())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		if (!Utils.esNumerico(request.getCantidaAmount())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT_NUMERICO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT_NUMERICO.getDescripcionClase());
			return false;
		}
		if (Utils.esVacio(request.getInventoryCode())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CANTIDAD_AMOUNT__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		
		return true;
	}
}
