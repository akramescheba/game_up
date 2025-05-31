package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Inventory;

public interface InventoryService {

	public List<Inventory> getAllInventory();

	public Inventory getInventoryById(Long id);

	public Long createInvotory(Inventory inventory);

	public void updateInventory(Long id, Inventory inventory);

	public void deleteInventory(Long id);

}
