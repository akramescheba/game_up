package com.gamesUP.gamesUP.dao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.services.RecommendationService;
import com.gamesUP.gamesUP.services.impl.RecommendationServiceImpl;

import dto.RecommendationDTO;

@DataJpaTest
@ActiveProfiles("test")

public class RecommendationRespositoryTest {
	@Autowired
	private RecommendationServiceImpl recommendationServiceImpl;

    public RecommendationRespositoryTest() {
    }
	
@Test
	void shouldHaveGetAllRecommendationRquest(){
		List<RecommendationDTO> recommendationResponse = recommendationServiceImpl.getAllRecommendation(1L);
		assertEquals(1, recommendationResponse.size());
		};
}
