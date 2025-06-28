package com.gamesUP.gamesUP.controller;

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
import com.gamesUP.gamesUP.model.Purchase;
import com.gamesUP.gamesUP.services.PurchaseService;

@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class PurchaseController {

	 @Autowired
	  private PurchaseService purchaseService;

	  //AJOUT DU VERBE GET - POUR AFFICHER  TOUTE LA LISTE D'ACHATS
	  @GetMapping("/purchases")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Purchase> getAllPurchase() {
	    return purchaseService.getAllPurchase();
	  }
	  //AJOUT DU VERBE GET  - POUR AFFICHER UNE LISTE D'ACHATS PAR ID
	  @GetMapping("/purchase/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public Purchase getPurchaseById(@PathVariable("id") Long id) {
		  Purchase purchase = purchaseService.getPurchaseById(id);

	    if (purchase == null) {}
	    return purchase;
	  }
	  //AJOUT DU VERBE POST  - AJOUTER UNE LISTE D'ACHATS PAR ID
	  @PostMapping("/purchase")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public Long createPurchase(@RequestBody Purchase purchase) {
	    return purchaseService.createPurchase(purchase);
	  }
	  //AJOUT DU VERBE PUT  - AJOUTER UNE LISTE D'ACHATS PAR ID
	  @PutMapping("/purchase/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updatePurchase(
	    @PathVariable Long id,
	    @RequestBody Purchase purchase
	  ) {
	    if (purchaseService.getPurchaseById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    purchaseService.updatePurchase(id, purchase);
	  }

	  //AJOUT DU VERBE DELETE  - SUPPRIMER UNE LISTE D'ACHATS PAR ID
	  @DeleteMapping("/purchase/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void deletePurchase(@PathVariable Long id) {
	    if (purchaseService.getPurchaseById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    purchaseService.deletePurchase(id);
	  }
	}


