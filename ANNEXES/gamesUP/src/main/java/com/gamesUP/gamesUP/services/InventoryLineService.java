package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.InventoryLine;

public interface InventoryLineService {

	public List<InventoryLine> getAllInventoryLine();

	public InventoryLine getInventoryLineById(Long id);

	public Long createInvotoryLine(InventoryLine inventoryLine);

	public void updateInventoryLine(Long id, InventoryLine inventoryLine);

	public void deleteInventoryLine(Long id);

}
