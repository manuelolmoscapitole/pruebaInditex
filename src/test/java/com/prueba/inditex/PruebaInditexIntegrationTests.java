package com.prueba.inditex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaInditexIntegrationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@DisplayName("Get all prices from database")
	@Test
	public void test0() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/all")).andExpect(status().isOk()).andExpect(jsonPath("$[0].price").value(35.50));
	}

	@DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1")
	@Test
	public void test1() throws Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("productID","35455");
	    map.add("brandID", "1");
	    map.add("applyAt", "2020-06-14T10:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice").
				contentType(MediaType.APPLICATION_JSON).params(map)).
				andExpect(status().isOk()).andExpect(content().json("{\"price\": 35.50}"));
	}
	
	@DisplayName("Petición a las 16:00 del día 14 del producto 35455 para la brand 1")
	@Test
	public void test2() throws Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("productID","35455");
	    map.add("brandID", "1");
	    map.add("applyAt", "2020-06-14T16:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice").
				contentType(MediaType.APPLICATION_JSON).params(map)).
				andExpect(status().isOk()).andExpect(content().json("{\"price\": 25.45}"));
	}
	
	@DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1")
	@Test
	public void test3() throws Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("productID","35455");
	    map.add("brandID", "1");
	    map.add("applyAt", "2020-06-14T21:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice").
				contentType(MediaType.APPLICATION_JSON).params(map)).
				andExpect(status().isOk()).andExpect(content().json("{\"price\": 35.50}"));
	}
	
	@DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1")
	@Test
	public void test4() throws Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("productID","35455");
	    map.add("brandID", "1");
	    map.add("applyAt", "2020-06-15T10:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice").
				contentType(MediaType.APPLICATION_JSON).params(map)).
				andExpect(status().isOk()).andExpect(content().json("{\"price\": 30.50}"));
	}
	
	@DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1")
	@Test
	public void test5() throws Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("productID","35455");
	    map.add("brandID", "1");
	    map.add("applyAt", "2020-06-16T21:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrice").
				contentType(MediaType.APPLICATION_JSON).params(map)).
				andExpect(status().isOk()).andExpect(content().json("{\"price\": 38.95}"));
	}
}
