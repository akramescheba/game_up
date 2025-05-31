package com.gamesUP.gamesUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Inventory;
import com.gamesUP.gamesUP.services.InventoryService;


@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	  //AJOUT DU VERBE GET - POUR AFFICHER  TOUS LES INVENTAIRES
	  @GetMapping("/inventories")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Inventory> getAllInventory() {
	    return inventoryService.getAllInventory();
	  }
	  //AJOUT DU VERBE GET  - POUR AFFICHER UN INVENTAIRES PAR ID
	  @GetMapping("/inventory/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public Inventory getInventoryById(@PathVariable("id") Long id) {
		  Inventory inventory = inventoryService.getInventoryById(id);

	    if (inventory == null) {}
	    return inventory;
	  }
	  //AJOUT DU VERBE POST  - AJOUTER UN INVENTAIRES PAR ID
	  @PostMapping("/inventory")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public Long createInvotory(@RequestBody Inventory inventory) {
	    return inventoryService.createInvotory(inventory);
	  }
	  //AJOUT DU VERBE PUT  - MODIFIER  UN INVENTAIRES PAR ID
	  @PutMapping("/inventory/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updateInventory(
	    @PathVariable Long id,@RequestBody Inventory inventory
	  ) {
	    if (inventoryService.getInventoryById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    inventoryService.updateInventory(id, inventory);
	  }

	  @DeleteMapping("/inventory/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void deleteInventory(@PathVariable Long id) {
	    if (inventoryService.getInventoryById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    inventoryService.deleteInventory(id);
	  }
}
