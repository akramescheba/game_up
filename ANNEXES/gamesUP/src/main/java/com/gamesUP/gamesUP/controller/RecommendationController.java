package com.gamesUP.gamesUP.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.model.RecommendationResponse;
import com.gamesUP.gamesUP.services.RecommendationService;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins="*")
public class RecommendationController {
	@Autowired
	private RecommendationService  recommendationService;
	@GetMapping("/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendations(@PathVariable Long userId) {
        List<RecommendationResponse> recommendations = recommendationService.getAllRecommendation(userId);
        return ResponseEntity.ok(recommendations);
    }
	}

