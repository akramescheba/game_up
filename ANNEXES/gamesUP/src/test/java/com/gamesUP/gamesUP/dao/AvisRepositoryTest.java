package com.gamesUP.gamesUP.dao;


import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Avis;

import com.gamesUP.gamesUP.services.impl.AvisServiceImpl;

@DataJpaTest
@ActiveProfiles("test")
public class AvisRepositoryTest {
	  @Autowired
	  private AvisServiceImpl avisRepositoryImpl;
	  @Test
	  void shouldGetAllAvis() {
	    List<Avis> avis = avisRepositoryImpl.getAllAvis();
	    assertEquals(1, avis.size());
	  }
	  @Test
	  void shouldGetAvisById() {
		  Avis avis = avisRepositoryImpl.getAvisById(1);
		  assertEquals(5, avis.getNote());
	  }
	    //Test Post
	    @Test
	    void shouldCreateAvis() {
	      Avis newAvis = new Avis();
	      newAvis.setNote(5);
	      newAvis.setDate(LocalDateTime.of(2025, 6, 26, 20, 45));
	      newAvis.setCommentaire("Merveilleux");
	      assertEquals(5, newAvis.getNote());
	      assertEquals("Merveilleux", newAvis.getCommentaire());
	      assertEquals(LocalDateTime.of(2025, 6, 26, 20, 45), newAvis.getDate());
	    }
	    //Test Update
	    @Test
	    void shouldUpdatePartialAvis() {
	  	  Avis avisExistant = avisRepositoryImpl.getAvisById(1);
	  	Avis newAvis = new Avis();
	  	newAvis.setCommentaire("Merveilleux");
	  	avisRepositoryImpl.updateAvis(1, avisExistant);
	    }
	    //Test delete
	    @Test
	    void shouldDeleteAvis() {
	    	avisRepositoryImpl.deleteAvis(1);
	  	};
		
}
