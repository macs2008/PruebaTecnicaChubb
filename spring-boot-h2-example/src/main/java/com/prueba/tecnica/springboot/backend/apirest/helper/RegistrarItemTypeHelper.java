package com.prueba.tecnica.springboot.backend.apirest.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.springboot.backend.apirest.dao.IITemType;
import com.prueba.tecnica.springboot.backend.apirest.dao.IItem;
import com.prueba.tecnica.springboot.backend.apirest.dao.IStock;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRegistroinicalItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.RequestRetirarItemStockWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseConsultaItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.ResponseRegistroInicialItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.wsdto.local.DetalleItemTypeWsDto;
import com.prueba.tecnica.springboot.backend.apirest.entity.ItemType;
import com.prueba.tecnica.springboot.backend.apirest.entity.Item;
import com.prueba.tecnica.springboot.backend.apirest.entity.Stock;
import com.prueba.tecnica.springboot.backend.apirest.enums.EnumPruebaTecnica;

@Service
public class RegistrarItemTypeHelper {

	@Autowired
	private IITemType IITemType;

	@Autowired
	private IItem iItem;

	@Autowired
	private IStock iStock;

	private ItemType itemType;

	private Item item;

	private Stock stock;

	private DetalleItemTypeWsDto detalleItemTypeWsDto;

	public boolean RegistrarItemTypeHelper(RequestRegistroinicalItemTypeWsDto request,
			ResponseRegistroInicialItemTypeWsDto response) {

		itemType = new ItemType();

		itemType.setItemType(request.getItemType());

		IITemType.save(itemType);

		item = new Item();

		item.setItemType(itemType);
		item.setItemNo(Integer.valueOf(request.getItemNo()));
		item.setName(request.getName().trim());

		iItem.save(item);

		stock = new Stock();

		stock.setItemType(itemType);
		stock.setCantidaAmount(Integer.valueOf(request.getCantidaAmount()));
		stock.setInventoryCode(request.getInventoryCode());
		stock.setAmountStock(Integer.valueOf(request.getCantidaAmount()));

		iStock.save(stock);

		return true;

	}

	public ResponseConsultaItemTypeWsDto consultarItemType(ResponseConsultaItemTypeWsDto response) {

		itemType = new ItemType();
		List<DetalleItemTypeWsDto> listaDetalleItemType = new ArrayList<>();

		List<ItemType> lista = IITemType.consultarItemType();

		if (lista.isEmpty()) {
			response.setCodigoRespuesta(EnumPruebaTecnica.NO_EXISTEN_REGISTROS.getCodigoClase());
			response.setDescripcionRespuesta(EnumPruebaTecnica.NO_EXISTEN_REGISTROS.getDescripcionClase());
		}
		for (ItemType itemType : lista) {
			detalleItemTypeWsDto = new DetalleItemTypeWsDto();
			detalleItemTypeWsDto.setIdItemType(itemType.getIdItemType().toString().trim());
			detalleItemTypeWsDto.setItemType(itemType.getItemType());

			listaDetalleItemType.add(detalleItemTypeWsDto);

		}
		response.setCodigoRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getCodigoClase());
		response.setDescripcionRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getDescripcionClase());
		response.setDetalleItemTypeWsDto(listaDetalleItemType);

		return response;
	}

	public List<DetalleItemTypeWsDto> consultarItemType1(ResponseConsultaItemTypeWsDto response) {

		itemType = new ItemType();
		List<DetalleItemTypeWsDto> listaDetalleItemType = new ArrayList<>();

		List<ItemType> lista = IITemType.consultarItemType();

		if (lista.isEmpty()) {
			response.setCodigoRespuesta(EnumPruebaTecnica.NO_EXISTEN_REGISTROS.getCodigoClase());
			response.setDescripcionRespuesta(EnumPruebaTecnica.NO_EXISTEN_REGISTROS.getDescripcionClase());
		}
		for (ItemType itemType : lista) {
			detalleItemTypeWsDto = new DetalleItemTypeWsDto();
			detalleItemTypeWsDto.setIdItemType(itemType.getIdItemType().toString().trim());
			detalleItemTypeWsDto.setItemType(itemType.getItemType());

			listaDetalleItemType.add(detalleItemTypeWsDto);

		}
		response.setCodigoRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getCodigoClase());
		response.setDescripcionRespuesta(EnumPruebaTecnica.CONSULTA_EXITOSA.getDescripcionClase());
		response.setDetalleItemTypeWsDto(listaDetalleItemType);

		return listaDetalleItemType;
	}

	public boolean retirarItemType(RequestRetirarItemStockWsDto reques,
			ResponseRegistroInicialItemTypeWsDto responseRegistroInicialItemType) {

		IITemType.deleteById(Long.valueOf(reques.getIdItemType()));
		iItem.deleteById(Long.valueOf(reques.getIdItemType()));
		iStock.deleteById(Long.valueOf(reques.getIdItemType()));

		return true;

	}
}
