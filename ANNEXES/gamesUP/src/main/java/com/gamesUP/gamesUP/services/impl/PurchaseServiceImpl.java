package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.PurchaseRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Purchase;
import com.gamesUP.gamesUP.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
	@Override
	public List<Purchase> getAllPurchase() {
		List<Purchase> purchase = new ArrayList<Purchase>();
		purchaseRepository.findAll().forEach(purchase::add);
		return purchase;
	}

	@Override
	public Purchase getPurchaseById(Long id) {
		   Optional<Purchase> purchase = purchaseRepository.findById(id);
		    if (purchase.isPresent()) {
		      return purchase.get();
		    }
		    throw new ExceptionEntityDontExist();
	}

	@Override
	public Long createPurchase(Purchase purchase) {
	    return purchaseRepository.save(purchase).getId();
	}

	@Override
	public void updatePurchase(Long id, Purchase purchase) {
	    Purchase purchaseExistant = purchaseRepository.findById(id)
	        .orElseThrow(ExceptionEntityDontExist::new);

	    purchaseExistant.setDate(purchase.getDate());
	    purchaseExistant.setPaid(purchase.isPaid());
	    purchaseExistant.setDelivered(purchase.isDelivered());
	    purchaseExistant.setArchived(purchase.isArchived());

	    purchaseRepository.save(purchaseExistant);
	}

	@Override
	public void deletePurchase(Long id) {
		purchaseRepository.deleteById(id);
		
	}


}
