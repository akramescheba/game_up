package com.gamesUP.gamesUP.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Avis;
import com.gamesUP.gamesUP.services.AvisService;

@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class AvisController {
	
	@Autowired
	private AvisService avisService;
	
	 //AJOUT DU VERBE GET - POUR AFFICHER LES TOUS AVIS
	@GetMapping("/avis")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Avis> getAllAvis(){
		return avisService.getAllAvis(); 
	}
	
	 //AJOUT DU VERBE GET - POUR AFFICHER UN AVIS PAR ID
	  @GetMapping("/avis/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public Avis getAvisById(@PathVariable("id") int id) {
	    Avis avis = avisService.getAvisById(id);

	    if (avis == null) {}
	    return avis;
	  }
	  
	  //AJOUT DU VERBE POST  - AJOUTER UN AVIS PAR ID
	  @PostMapping("/avis")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public int createAvis(@RequestBody Avis avis) {
		  avis.setDate(LocalDateTime.now());
	    return avisService.createAvis(avis);
	  }
	  
	  //AJOUT DU VERBE PUT  - MODIFIER UN AVIS PAR ID
	  @PutMapping("/avis/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updateAvis(@PathVariable int id, @RequestBody Avis avis) {
	    if (avisService.getAvisById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    avisService.updateAvis(id, avis);
	  }
	  
	  
	  //AJOUT DU VERBE DELETE  - SUPPRIMER UN AVIS
	  @DeleteMapping("/avis/{id}")
	  @ResponseStatus(code=HttpStatus.OK)
	  public void deleteAvis(@PathVariable int id) {
		  if (avisService.getAvisById(id) == null) {
		      throw new ExceptionEntityDontExist();
		    }
		  avisService.deleteAvis(id);

		  }

}
