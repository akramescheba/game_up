package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gamesUP.gamesUP.dao.PurchaseRepository;
import com.gamesUP.gamesUP.model.Purchase;
import com.gamesUP.gamesUP.model.PurchaseLine;
import com.gamesUP.gamesUP.model.RecommendationPurchase;
import com.gamesUP.gamesUP.model.RecommendationRequest;
import com.gamesUP.gamesUP.model.RecommendationResponse;
import com.gamesUP.gamesUP.services.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService{
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	private final String URL_API = "http://127.0.0.1:8000/recommendations/";
	@Override
	public List<RecommendationResponse> getAllRecommendation(Long userId) {
		List<Purchase> purchases = purchaseRepository.findUserById(userId);
		
		List<RecommendationPurchase> recommendationPurchases =new ArrayList<>();
		
		for(Purchase purchase:purchases) {
			for(PurchaseLine line:purchase.getLine()) {
				recommendationPurchases.add(
						new RecommendationPurchase(
								line.getGame().getId(),
								line.getRating()
								)
						);
				}
		}
		RecommendationRequest request = new RecommendationRequest();
		request.setUser_id(userId);
		request.setPurchases(recommendationPurchases);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<RecommendationResponse>> response = restTemplate.exchange(
			    URL_API,
			    HttpMethod.POST,
			    new HttpEntity<>(request),
			    new ParameterizedTypeReference<List<RecommendationResponse>>() {}
			);

	        return response.getBody();

	}
	

}
