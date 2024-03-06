package com.prueba.inditex.service.prices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.inditex.entity.prices.Prices;
import com.prueba.inditex.repository.prices.PricesRepository;

@Service
public class PricesServicesImpl implements PricesService {
	
	@Autowired
	private PricesRepository pricesRepository;

	@Override
	public List<Prices> getAll() {
		
		return pricesRepository.findAll();
	}

	@Override
	public Prices getPricesByProductIdAndBrandId(Integer productId, Integer brandId, LocalDateTime applyAt) {
		
		List<Prices> list = pricesRepository.findByProductIdAndBrandIdOrderByPriorityDesc(productId, brandId);
		
		// Filter the list of prices using the apply date and return only the highest priority
		Prices prices = list.stream().filter(price -> (price.getStartDate().isBefore(applyAt) || price.getStartDate().isEqual(applyAt)) && 
				(price.getEndDate().isAfter(applyAt) || price.getEndDate().isEqual(applyAt))).findFirst().orElse(new Prices());
		
		return prices;
	}
	
}
