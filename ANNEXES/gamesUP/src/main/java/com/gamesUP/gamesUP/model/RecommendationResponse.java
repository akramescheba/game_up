package com.gamesUP.gamesUP.model;
import java.util.List;

import dto.RecommendationDTO;
public class RecommendationResponse {
	private Long user_id;
    private List<RecommendationDTO> recommendations;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public List<RecommendationDTO> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<RecommendationDTO> recommendations) {
		this.recommendations = recommendations;
	}

}
