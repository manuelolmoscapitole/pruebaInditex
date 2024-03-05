package com.prueba.inditex.repository.prices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.inditex.entity.prices.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer>{

}
