package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.RecommendationResponse;

public interface RecommendationService {

	List<RecommendationResponse> getAllRecommendation(Long userId);

}
