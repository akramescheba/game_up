package com.gamesUP.gamesUP.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.gamesUP.gamesUP.model.RecommendationResponse;
import com.gamesUP.gamesUP.services.RecommendationService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")

public class RecommendationRespositoryTest {
	@Autowired
	private RecommendationService recommendationService;
	
	@Test
	void shouldHaveGetAllRecommendationRquest(){
		List<RecommendationResponse> recommendationResponse = recommendationService.getAllRecommendation(1L);
		assertEquals(3, recommendationResponse.size());
		};
}
