package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.InventoryRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Inventory;
import com.gamesUP.gamesUP.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> getAllInventory() {
		List<Inventory> inventory = new ArrayList<Inventory>();
		inventoryRepository.findAll().forEach(inventory::add);
		return inventory;
	}

	@Override
	public Inventory getInventoryById(Long id) {
		  Optional<Inventory> inventory = inventoryRepository.findById(id);
		    if (inventory.isPresent()) {
		      return inventory.get();
		    }
		    throw new ExceptionEntityDontExist();
	}

	@Override
	public Long createInvotory(Inventory inventory) {
		return inventoryRepository.save(inventory).getId();
	}

	@Override
	public void updateInventory(Long id, Inventory inventory) {
		Inventory inventoryExistante = inventoryRepository.findById(id)
			      .orElseThrow(() -> new ExceptionEntityDontExist());
		inventoryExistante.setStock(inventory.getStock());
			  inventoryRepository.save(inventoryExistante);
		
	}

	@Override
	public void deleteInventory(Long id) {
		inventoryRepository.deleteById(id);
	}

}
