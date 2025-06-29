package com.gamesUP.gamesUP.dao;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.PurchaseLine;
import com.gamesUP.gamesUP.services.PurchaseLineService;

@DataJpaTest
@ActiveProfiles("test")
public class PurchaseLineRepositoryTest {
	
	  @Autowired
	  private PurchaseLineService purchaseLineService;
	  @Test
	  void shouldGetAllPurchaseLine() {
		    List<PurchaseLine> purchaseLine = purchaseLineService.getAllPurchaseLine();
		    assertEquals(1, purchaseLine.size());
		  }
	  @Test
	  void shouldGetPurchaseLineById() {
	    PurchaseLine purchaseLine = purchaseLineService.getPurchaseLineById(1);
	    assertEquals(1, purchaseLine.getId());
	  }
	    @Test
	    void shouldCreatePurchaseLine() {
	    	PurchaseLine newPurchaseLine= new PurchaseLine();
	    	newPurchaseLine.setId(1);
	    	purchaseLineService.createPurchaseLine(newPurchaseLine);
	      assertEquals(1, newPurchaseLine.getId());
	    }
	    @Test
	    void shouldUpdatePurchaseLine() {
	    	PurchaseLine purchaseLine = purchaseLineService.getPurchaseLineById(1);
	    	PurchaseLine newPurchaseLine = new PurchaseLine();
	    	newPurchaseLine.setId(1);
	    	purchaseLineService.updatePurchaseLine(1, purchaseLine);

	    }

	    @Test
	    void shouldDeletePurchaseLine() {
	    	PurchaseLine purchaseLine = purchaseLineService.getPurchaseLineById(1);
	    	purchaseLine.setId(1);
	    	purchaseLineService.deletePurchaseLine(1);
	    	assertEquals(1, purchaseLine.getId());
	  	};
		

}
