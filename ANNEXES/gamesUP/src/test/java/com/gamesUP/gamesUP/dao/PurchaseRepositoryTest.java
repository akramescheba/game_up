package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Purchase;
import com.gamesUP.gamesUP.services.PurchaseService;


@DataJpaTest
@ActiveProfiles("test")
public class PurchaseRepositoryTest {
	  @Autowired
	  private PurchaseService purchaseService;
	  void shouldGetAllPurchase() {
		    List<Purchase> purchase = purchaseService.getAllPurchase();
		    assertEquals(1, purchase.size());
		  }
	  @Test
	  void shouldGetPurchaseById() {
	    Purchase purchase = purchaseService.getPurchaseById(1L);
	    assertEquals(1, purchase.getId());
	  }
	    @Test
	    void shouldCreatePurchase() {
	    	Purchase newPurchase = new Purchase();
	    	newPurchase.setArchived(false);
	      assertEquals(false, newPurchase.isArchived());
	    }
	    @Test
	    void shouldUpdatePurchase() {
	    	Purchase purchase= purchaseService.getPurchaseById(1L);
	    	Purchase newPurchase = new Purchase();
	    	newPurchase.setArchived(false);
	    	purchaseService.updatePurchase(1L, purchase);
	    }

	    @Test
	    void shouldDeletePurchase() {
	    	purchaseService.deletePurchase(1L);
	  	};
		

}
