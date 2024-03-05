package com.prueba.inditex.service.prices;

import java.util.List;
import java.util.Optional;

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
	
}
