package com.tipre.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tipre.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos") //El nombre que pusimos en el app.properties a nuestra spring.app y su url con puerto
public interface ProductoClienteRest {
	
	@GetMapping("/productos") //Misma anotacion que en mi otro microservicio
	public List<Producto> getProducto();
	
	@GetMapping("/ver/{id}")
	public Producto buscarProducto(@PathVariable Long id);
}
