package com.micro.uizuulapp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class HomeController {
	
	@Autowired
	private OAuth2RestTemplate oauth2RestTemplate;
	
	@Value("${catalog.api:http://localhost:8181/catalog/products}")
	private String catalogApi;

	@RequestMapping(value = "/")
	public String getIndex(Model model) {
		ResponseEntity<ProductDTO[]> productdto = 
				oauth2RestTemplate.getForEntity(catalogApi, ProductDTO[].class);
		List<ProductDTO> dataProductDto = Arrays.asList(productdto.getBody());
		model.addAttribute("products", dataProductDto);
		return "index";
	}
	
}


