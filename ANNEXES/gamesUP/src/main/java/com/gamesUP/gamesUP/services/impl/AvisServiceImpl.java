package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.AvisRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Avis;
import com.gamesUP.gamesUP.services.AvisService;

@Service
public class AvisServiceImpl implements AvisService{
	   @Autowired
	    private AvisRepository avisRepository;

	@Override
	public List<Avis> getAllAvis() {
		List<Avis> avis = new ArrayList<Avis>();
		avisRepository.findAll().forEach(avis::add);
		return avis;
	}

	@Override
	public Avis getAvisById(int id) {
	    Optional<Avis> avis = avisRepository.findById(id);
	    if (avis.isPresent()) {
	      return avis.get();
	    }
	    throw new ExceptionEntityDontExist();
	  }

	@Override
	public void updateAvis(int id, Avis avis) {
	    Avis avisExistant = avisRepository.findById(id)
	            .orElseThrow(() -> new ExceptionEntityDontExist());
	    avisExistant.setNote(avis.getNote());
	    avisExistant.setCommentaire(avis.getCommentaire());
	        avisRepository.save(avisExistant); 
	    }

	@Override
	public int createAvis(Avis avis) {
		   return avisRepository.save(avis).getId();
	  }

	@Override
	public void deleteAvis(int id) {
		avisRepository.deleteById(id);
		
	}

	}


