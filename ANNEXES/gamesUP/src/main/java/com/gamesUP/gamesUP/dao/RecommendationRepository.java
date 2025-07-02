package com.gamesUP.gamesUP.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gamesUP.gamesUP.model.RecommendationPurchase;

public interface RecommendationRepository extends CrudRepository<RecommendationPurchase, Long> {
	   List<RecommendationPurchase> findByUserId(Long userId);
}
