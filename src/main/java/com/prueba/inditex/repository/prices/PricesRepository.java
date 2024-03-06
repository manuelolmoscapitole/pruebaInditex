package com.prueba.inditex.repository.prices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.inditex.entity.prices.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer>{

	// Get the prices filtered by productId and brandId ordered by Priority (high priority first)
	List<Prices> findByProductIdAndBrandIdOrderByPriorityDesc(Integer productId, Integer brandId);

}
