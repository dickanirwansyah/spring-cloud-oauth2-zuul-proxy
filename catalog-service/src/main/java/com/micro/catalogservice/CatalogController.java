package com.micro.catalogservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
	
	@Autowired private PromotionServiceClient promotionServiceClient;
	
	@RequestMapping(value = "/products")
	public List<ProductDTO> getDataProducts(){
		List<ProductDTO> dtos = new ArrayList<>();
		List<Product> products = listProducts();
		for (Product product : products) {
			String promotion = null;
			try {
				promotion = promotionServiceClient.getPromotionByProductId(product.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}
			dtos
				.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), promotion));
		}
		return dtos;
	}
	
	private List<Product> listProducts(){
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "Iphone", 67.00));
		products.add(new Product(2L, "Samsung", 65.00));
		products.add(new Product(3L, "Xiaomi", 55.00));
		return products;
	}

}
