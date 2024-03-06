package com.prueba.inditex.controller.prices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody List<Prices> getAllPrices() {
		return pricesService.getAll();
	}
	
	@GetMapping("/getPrice")
	public @ResponseBody Prices getPriceByProductAndBrandAndDate(@RequestParam(name = "productID") Integer productId,
			@RequestParam(name = "brandID") Integer brandId,
			@RequestParam(name = "applyAt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applyAt) {
		
		return pricesService.getPricesByProductIdAndBrandId(productId, brandId, applyAt);
	
	}
}
