package com.gamesUP.gamesUP.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.services.RecommendationService;

import dto.RecommendationDTO;

@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class RecommendationController {
	@Autowired
	private RecommendationService  recommendationService;
	@GetMapping("/recommendations")
    public List<RecommendationDTO> getAllRecommendation() {
        return recommendationService.getAllRecommendation();
        }
	
	@GetMapping("/recommendations/{userId}")
    public ResponseEntity<List<RecommendationDTO>> getRecommendations(@PathVariable Long userId) {
        List<RecommendationDTO> recommendations = recommendationService.getRecommendations(userId);
        return ResponseEntity.ok(recommendations);
        }
	}

