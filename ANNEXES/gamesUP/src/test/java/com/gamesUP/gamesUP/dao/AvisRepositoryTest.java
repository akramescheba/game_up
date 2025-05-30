package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		  assertEquals(10, avis.getNote());
	  }
	    //Test Post
	    @Test
	    void shouldCreateAvis() {
	      Avis newAvis = new Avis();
	      newAvis.setNote(10);
	      newAvis.setCommentaire("Merveilleux");
	      assertEquals(10, newAvis.getNote());
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
