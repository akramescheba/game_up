package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.PurchaseLineRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Purchase;
import com.gamesUP.gamesUP.model.PurchaseLine;
import com.gamesUP.gamesUP.services.PurchaseLineService;

@Service
public class PurchaseLineServiceImpl implements PurchaseLineService{

	   @Autowired
	    private PurchaseLineRepository purchaseLineRepository;
	@Override
	public List<PurchaseLine> getAllPurchaseLine() {
		List<PurchaseLine> purchaseLine = new ArrayList<PurchaseLine>();
		purchaseLineRepository.findAll().forEach(purchaseLine::add);
		return purchaseLine;
	}
	@Override
	public PurchaseLine getPurchaseLineById(int id) {
		   Optional<PurchaseLine> purchaseLine = purchaseLineRepository.findById(id);
		    if (purchaseLine.isPresent()) {
		      return purchaseLine.get();
		    }
		    throw new ExceptionEntityDontExist();
	}
	@Override
	public int createPurchaseLine(PurchaseLine purchaseLine) {
		return purchaseLineRepository.save(purchaseLine).getId();
	}
	@Override
	public void deletePurchaseLine(int id) {
		purchaseLineRepository.deleteById(id);
		
	}
	@Override
	public void updatePurchaseLine(int id, PurchaseLine purchaseLine) {
	    PurchaseLine purchaseLineExistant = purchaseLineRepository.findById(id)
		        .orElseThrow(ExceptionEntityDontExist::new);

	    purchaseLineExistant.setJeuId(purchaseLine.getJeuId());
	    purchaseLineExistant.setPrix(purchaseLine.getPrix());
	    purchaseLineExistant.setPurchase(purchaseLine.getPurchase());
	    purchaseLineExistant.setUtilisateurId(purchaseLine.getUtilisateurId());

		    purchaseLineRepository.save(purchaseLineExistant);
		
	}



}
