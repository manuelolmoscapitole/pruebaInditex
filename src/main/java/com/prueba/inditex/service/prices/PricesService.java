package com.prueba.inditex.service.prices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.prueba.inditex.entity.prices.Prices;

public interface PricesService {

	List<Prices> getAll();
	
	Optional<Prices> getPricesByProductIdAndBrandId(Integer productId, Integer brandId, LocalDateTime applyAt);
}
