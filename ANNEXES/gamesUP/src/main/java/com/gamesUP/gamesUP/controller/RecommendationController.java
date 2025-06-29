package com.gamesUP.gamesUP.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.services.RecommendationService;

import dto.RecommendationDTO;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class RecommendationController {
	@Autowired
	private RecommendationService  recommendationService;
	@GetMapping("/{userId}")
    public ResponseEntity<List<RecommendationDTO>> getRecommendations(@PathVariable Long userId) {
        List<RecommendationDTO> recommendations = recommendationService.getAllRecommendation(userId);
        return ResponseEntity.ok(recommendations);
        }
	}

