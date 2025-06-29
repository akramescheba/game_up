package com.gamesUP.gamesUP.services;

import java.util.List;

import dto.RecommendationDTO;

public interface RecommendationService {

	List<RecommendationDTO> getAllRecommendation(Long userId);

}
