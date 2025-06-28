package com.gamesUP.gamesUP.model;

public class RecommendationPurchase {
	private Long game_id;
	private Double rating;
	
	public RecommendationPurchase(Long gameId, Double rating) {
		this.game_id = gameId;
		this.rating=rating;
	}

	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

}
