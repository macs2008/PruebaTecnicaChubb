package com.prueba.tecnica.springboot.backend.apirest.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.springboot.backend.apirest.servicio.utilidades.Utils;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRetirarItemStockWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseRegistroInicialItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.enums.EnumPruebaTecnica;
import com.prueba.tecnica.springboot.backend.apirest.helper.RegistrarItemTypeHelper;

@Service
public class RetirarItemTypeService {

	private final static Logger logger = Logger.getLogger(RetirarItemTypeService.class.getName());
	
	private ResponseRegistroInicialItemTypeWsDto responseRegistroInicialItemType;
	
	
	@Autowired
	private RegistrarItemTypeHelper registrarItemTypeHelper;
	
	public ResponseRegistroInicialItemTypeWsDto retirarItemTypeService(RequestRetirarItemStockWsDto request) {
	
	responseRegistroInicialItemType = new ResponseRegistroInicialItemTypeWsDto();
	
	
	if(!validarDatosBeneficiarioConDiscapacidad(request)){
		return responseRegistroInicialItemType;
	}
	
	
	if(registrarItemTypeHelper.retirarItemType(request, responseRegistroInicialItemType)) {
		responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getCodigoClase());
		responseRegistroInicialItemType.setDescripcionRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getDescripcionClase());
		return responseRegistroInicialItemType;
	}
	
	return responseRegistroInicialItemType;
}
	
	
	public boolean validarDatosBeneficiarioConDiscapacidad(RequestRetirarItemStockWsDto request) {
		
		
		if (request == null || Utils.esVacio(request.getIdItemType())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE__OBLIGATORIO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE__OBLIGATORIO.getDescripcionClase());
			return false;
		}
		
		if (!Utils.esNumerico(request.getIdItemType())) {
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE_NUMERICO.getCodigoClase());
			responseRegistroInicialItemType.setCodigoRespuesta(EnumPruebaTecnica.ITEM_TYPE_NUMERICO.getDescripcionClase());
			return false;
		}
		
		return true;
	}
}
