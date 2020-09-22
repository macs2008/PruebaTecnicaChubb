package com.prueba.tecnica.springboot.backend.apirest.negocio;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.springboot.backend.apirest.enums.EnumPruebaTecnica;
import com.prueba.tecnica.springboot.backend.apirest.helper.RegistrarItemTypeHelper;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseConsultaItemTypeWsDto;


import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.DetalleItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.servicio.utilidades.Utils;

@Service
public class ConsultaItemTypeService {

	private final static Logger logger = Logger.getLogger(RegistrarItemTypeService.class.getName());
	
	private ResponseConsultaItemTypeWsDto responseConsultaItemTypeWsDto;
	
	private DetalleItemTypeWsDto detalleItemTypeWsDto;
	
	@Autowired
	private RegistrarItemTypeHelper registrarItemTypeHelper;
	
	public ResponseConsultaItemTypeWsDto consultaItemType() {
		
		responseConsultaItemTypeWsDto = new ResponseConsultaItemTypeWsDto();
		
		
		registrarItemTypeHelper.consultarItemType(responseConsultaItemTypeWsDto);
		
		
		return responseConsultaItemTypeWsDto;
	}
	
	public List<DetalleItemTypeWsDto> consultaItemType1() {
		
		responseConsultaItemTypeWsDto = new ResponseConsultaItemTypeWsDto();
		
		
		List<DetalleItemTypeWsDto> prueba = registrarItemTypeHelper.consultarItemType1(responseConsultaItemTypeWsDto);
		
		
		return prueba;
	}
}
