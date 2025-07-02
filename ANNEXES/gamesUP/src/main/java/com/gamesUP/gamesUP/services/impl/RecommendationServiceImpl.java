package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gamesUP.gamesUP.dao.RecommendationRepository;
import com.gamesUP.gamesUP.model.RecommendationResponse;
import com.gamesUP.gamesUP.services.RecommendationService;

import dto.RecommendationDTO;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    RecommendationRepository recommendationRepository;

    @SuppressWarnings("null")
	@Override
    public List<RecommendationDTO> getRecommendations(Long userId) {
        String pythonApiUrl = "http://localhost:8000/recommendations";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("user_id", userId);
        requestBody.put("purchases", new ArrayList<>()); 

        ResponseEntity<RecommendationResponse> response = restTemplate.postForEntity(
            pythonApiUrl,
            requestBody,
            RecommendationResponse.class
        );
        return response.getBody().getRecommendations();
    }

	@Override
	public List<RecommendationDTO> getAllRecommendation() {
		List<RecommendationDTO> recommendationsList = new ArrayList<RecommendationDTO>();
		RecommendationDTO recommendationsDTO = new RecommendationDTO();
		recommendationsList.add(recommendationsDTO);
		return recommendationsList;
	}
}