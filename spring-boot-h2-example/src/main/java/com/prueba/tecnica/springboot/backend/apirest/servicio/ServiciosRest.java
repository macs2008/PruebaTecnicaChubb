package com.prueba.tecnica.springboot.backend.apirest.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.tecnica.springboot.backend.apirest.servicio.utilidades.ConfigSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.DetalleItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRegistroinicalItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseConsultaItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseRegistroInicialItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRetirarItemStockWsDto;
import com.prueba.tecnica.springboot.backend.apirest.negocio.RegistrarItemTypeService;
import com.prueba.tecnica.springboot.backend.apirest.negocio.ConsultaItemTypeService;
import com.prueba.tecnica.springboot.backend.apirest.negocio.RetirarItemTypeService;

@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/IntegradorPruebaTecnica/ServiciosRest")
@Api(value="ServiciosRest", tags = { ConfigSwagger.DESCRIPCION_SERVICIO })
public class ServiciosRest {

	@Autowired
	private RegistrarItemTypeService registrarItemTypeService;
	
	@Autowired
	private ConsultaItemTypeService consultaItemTypeService;
	
	@Autowired
	private RetirarItemTypeService retirarItemTypeService;
	
	
	@ApiOperation(value = "Inserta el item en las tablas corresponeintes")
	@RequestMapping(path = "/registrarItemType", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseRegistroInicialItemTypeWsDto registrarItemType(@RequestBody RequestRegistroinicalItemTypeWsDto request) {

		ResponseRegistroInicialItemTypeWsDto response = registrarItemTypeService.registrarItemTypeService(request);
		
		return response;
	}
	
	@ApiOperation(value = "Consulta los tipos de identificacion")
	@RequestMapping(path="/consultaItemType", method = RequestMethod.GET, produces = "application/json")
	public ResponseConsultaItemTypeWsDto consultaItemType() {

		ResponseConsultaItemTypeWsDto response = consultaItemTypeService.consultaItemType();
		
		return response;
	}
	
	@ApiOperation(value = "Consulta los tipos de identificacion")
	@RequestMapping(path="/consultaItemType1", method = RequestMethod.GET, produces = "application/json")
	public  List<DetalleItemTypeWsDto> consultaItemType1() {

		 List<DetalleItemTypeWsDto> response = consultaItemTypeService.consultaItemType1();
		
		return response;
	}
	
	@ApiOperation(value = "Inserta el item en las tablas corresponeintes")
	@RequestMapping(path = "/retirarItemStock", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseRegistroInicialItemTypeWsDto retirarItemStock(@RequestBody RequestRetirarItemStockWsDto request) {

		
		ResponseRegistroInicialItemTypeWsDto response = retirarItemTypeService.retirarItemTypeService(request);
		
		return response;
	}
	
}
