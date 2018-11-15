package com.micro.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Repository;

import lombok.Data;

/** consume promotion **/

@Repository
public class PromotionServiceClient {

	
	@Autowired OAuth2RestTemplate oauth2RestTemplate;
	
	String URI = "http://localhost:8282/promotions/products/{id}/promotion";
	
	public String getPromotionByProductId(Long id) {
		ResponseEntity<PromotionDTO> promoDTO = oauth2RestTemplate
				.getForEntity(URI, PromotionDTO.class, id);
		return promoDTO.getBody().getPromoText();
	}
	
}

/** class promotion dto **/
@Data
class PromotionDTO {
	private Long id;
	private Long productId;
	private String promoText;
}

