package com.prueba.inditex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.inditex.entity.prices.Prices;
import com.prueba.inditex.repository.prices.PricesRepository;
import com.prueba.inditex.service.prices.PricesServicesImpl;

@SpringBootTest
public class PruebaInditexUnitTest {

    @Mock
    private PricesRepository priceRepository;

    @InjectMocks
    private PricesServicesImpl priceService;

    @Test
    public void testWithinDateRange() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;

        Prices expectedPrice = new Prices(1, brandId, date, date.plusYears(1), Integer.valueOf(1), productId, Integer.valueOf(1), BigDecimal.valueOf(35.50), "EUR");
        when(priceRepository.findByProductIdAndBrandIdOrderByPriorityDesc(any(Integer.class), any(Integer.class)))
                .thenReturn(Arrays.asList(expectedPrice));

        Prices actualPrice = priceService.getPricesByProductIdAndBrandIdForAGivenDate(productId, brandId, date);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testOutsideDateRange() {
        LocalDateTime date = LocalDateTime.of(2021, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;

        when(priceRepository.findByProductIdAndBrandIdOrderByPriorityDesc(any(Integer.class), any(Integer.class)))
                .thenReturn(Arrays.asList());

        Prices prices = priceService.getPricesByProductIdAndBrandIdForAGivenDate(productId, brandId, date);
        assertEquals(Prices.builder().build(), prices);
    }

    @Test
    public void testNonExistingProductAndBrand() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 12345; // Producto no existente
        int brandId = 2; // Marca no existente

        when(priceRepository.findByProductIdAndBrandIdOrderByPriorityDesc(any(Integer.class), any(Integer.class)))
                .thenReturn(Arrays.asList());

        Prices prices = priceService.getPricesByProductIdAndBrandIdForAGivenDate(productId, brandId, date);
        assertEquals(null, prices.getPrice());
    }
}
