package com.gamesUP.gamesUP.model;

import java.util.List;

public class RecommendationRequest {
	private Long user_id;
	private List<RecommendationPurchase> purchases;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public List<RecommendationPurchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<RecommendationPurchase> purchases) {
		this.purchases = purchases;
	}
	

}
