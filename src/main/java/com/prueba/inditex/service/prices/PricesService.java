package com.prueba.inditex.service.prices;

import java.time.LocalDateTime;
import java.util.List;

import com.prueba.inditex.entity.prices.Prices;

public interface PricesService {

	List<Prices> getAll();
	
	Prices getPricesByProductIdAndBrandIdForAGivenDate(Integer productId, Integer brandId, LocalDateTime applyAt);
}
