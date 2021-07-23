package com.tipre.springboot.app.item.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tipre.springboot.app.item.clientes.ProductoClienteRest;
import com.tipre.springboot.app.item.models.Item;


@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.getProducto().stream().map( p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.buscarProducto(id), cantidad) ;
	}

}
