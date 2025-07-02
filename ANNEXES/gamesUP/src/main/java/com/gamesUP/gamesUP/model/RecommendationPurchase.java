package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecommendationPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long game_id;
    private String game_name;
    public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	private Long userId;
	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long userId) {
		this.userId = userId;
	}

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
