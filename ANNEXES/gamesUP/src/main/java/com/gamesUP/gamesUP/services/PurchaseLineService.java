package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.PurchaseLine;

public interface PurchaseLineService {


	public List<PurchaseLine> getAllPurchaseLine();

	public PurchaseLine getPurchaseLineById(int id);

	public int createPurchaseLine(PurchaseLine purchaseLine);

	public void deletePurchaseLine(int id);

	public void updatePurchaseLine(int id, PurchaseLine purchaseLine);




}
