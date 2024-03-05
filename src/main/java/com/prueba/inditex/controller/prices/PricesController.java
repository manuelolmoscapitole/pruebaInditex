package com.prueba.inditex.controller.prices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.inditex.entity.prices.Prices;
import com.prueba.inditex.service.prices.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	private PricesService pricesService;
	
	@GetMapping("/all")
	public @ResponseBody List<Prices> obtenerTodos() {
		return pricesService.getAll();
	}
	

}
