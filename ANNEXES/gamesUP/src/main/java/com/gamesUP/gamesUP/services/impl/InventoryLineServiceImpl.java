package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.InventoryLineRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.InventoryLine;
import com.gamesUP.gamesUP.services.InventoryLineService;

@Service
public class InventoryLineServiceImpl implements InventoryLineService{
	@Autowired
	private InventoryLineRepository inventoryLineRepository;
	@Override
	public List<InventoryLine> getAllInventoryLine() {
		List<InventoryLine> inventoryLine = new ArrayList<InventoryLine>();
		inventoryLineRepository.findAll().forEach(inventoryLine::add);
		return inventoryLine;
	}
	@Override
	public InventoryLine getInventoryLineById(Long id) {
		  Optional<InventoryLine> inventoryLine = inventoryLineRepository.findById(id);
		    if (inventoryLine.isPresent()) {
		      return inventoryLine.get();
		    }
		    throw new ExceptionEntityDontExist();
	}
	@Override
	public Long createInvotoryLine(InventoryLine inventoryLine) {
		return inventoryLineRepository.save(inventoryLine).getId();
	}
	@Override
	public void updateInventoryLine(Long id, InventoryLine inventoryLine) {
		InventoryLine inventoryLineExistante = inventoryLineRepository.findById(id)
			      .orElseThrow(() -> new ExceptionEntityDontExist());
		inventoryLineExistante.setGame(inventoryLine.getGame());
		inventoryLineExistante.setInventory(inventoryLine.getInventory());
		inventoryLineExistante.setQuantity(inventoryLine.getQuantity());
			  inventoryLineRepository.save(inventoryLineExistante);
		
	}
	@Override
	public void deleteInventoryLine(Long id) {
		inventoryLineRepository.deleteById(id);
		
	}


}
