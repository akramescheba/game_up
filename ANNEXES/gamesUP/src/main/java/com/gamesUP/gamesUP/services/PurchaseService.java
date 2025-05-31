package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Purchase;

public interface PurchaseService {

	public List<Purchase> getAllPurchase();

	public Purchase getPurchaseById(Long id);

	public Long createPurchase(Purchase purchase);

	public void updatePurchase(Long id, Purchase purchase);

	public void deletePurchase(Long id);

}
