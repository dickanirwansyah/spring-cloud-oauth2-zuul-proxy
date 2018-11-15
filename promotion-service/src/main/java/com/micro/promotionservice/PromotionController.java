package com.micro.promotionservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {

	private static final Map<Long, Promotion> PROMOTION_MAP = new HashMap<>();
	
	@PostConstruct
	void init() {
		for (int i=1; i <= 10; i++) {
			String promo = (i % 2 == 0) ? "Product- "+i+"-Promotion": null;
			Promotion p = new Promotion(Long.valueOf(i), Long.valueOf(i), promo);
			PROMOTION_MAP.put(p.getProductId(), p);
		}
	}
	
	@RequestMapping(value = "/products/{id}/promotion", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Promotion getPromotionsByID(@PathVariable("id") Long id) {
		return PROMOTION_MAP.get(id);
	}
	
	@RequestMapping(value = "/promotions", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Promotion> getAllPromotions(){
		return PROMOTION_MAP.values();
	}
	
}
