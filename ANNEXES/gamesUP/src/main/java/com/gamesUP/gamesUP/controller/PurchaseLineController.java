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
import com.gamesUP.gamesUP.model.PurchaseLine;
import com.gamesUP.gamesUP.services.PurchaseLineService;


@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class PurchaseLineController {
	 @Autowired
	  private PurchaseLineService purchaseLineService;

	  //AJOUT DU VERBE GET 
	  @GetMapping("/purchase-lines")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<PurchaseLine> getAllPurchaseLine() {
	    return purchaseLineService.getAllPurchaseLine();
	  }
	  @GetMapping("/purchase-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public PurchaseLine getPurchaseLineById(@PathVariable("id") int id) {
		  PurchaseLine purchaseLine = purchaseLineService.getPurchaseLineById(id);

	    if (purchaseLine == null) {}
	    return purchaseLine;
	  }
	  //AJOUT DU VERBE POST  
	  @PostMapping("/purchase-line")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public int createPurchaseLine(@RequestBody PurchaseLine purchaseLine) {
	    return purchaseLineService.createPurchaseLine(purchaseLine);
	  }
	  
	  @PutMapping("/purchase-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updatePurchaseLine(@PathVariable int id,
	    @RequestBody PurchaseLine purchaseLine
	  ) {
	    if (purchaseLineService.getPurchaseLineById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    purchaseLineService.updatePurchaseLine(id, purchaseLine);
	  }

	  @DeleteMapping("/purchase-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void deletePurchaseLine(@PathVariable int id) {
	    if (purchaseLineService.getPurchaseLineById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    purchaseLineService.deletePurchaseLine(id);
	  }

}
