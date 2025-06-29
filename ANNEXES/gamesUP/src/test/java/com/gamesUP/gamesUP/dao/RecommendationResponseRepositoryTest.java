package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.RecommendationRequest;
import com.gamesUP.gamesUP.model.RecommendationResponse;
import com.gamesUP.gamesUP.services.impl.RecommendationServiceImpl;

import dto.RecommendationDTO;


@DataJpaTest
@ActiveProfiles("test")
public class RecommendationResponseRepositoryTest {
	@Autowired
	private RecommendationServiceImpl recommendationServiceImpl;
	@Test
	void shouldIRecommendateResponse() {
		List<RecommendationDTO> RecommendationRequest = recommendationServiceImpl.getAllRecommendation(1L);
		assertEquals(2, RecommendationRequest.size());
	};
	}
