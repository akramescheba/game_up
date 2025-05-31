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
import com.gamesUP.gamesUP.model.InventoryLine;
import com.gamesUP.gamesUP.services.InventoryLineService;

@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")

public class InventoryLineController {
	@Autowired
	private InventoryLineService inventoryLineService;
	  //AJOUT DU VERBE GET 
	  @GetMapping("/inventory-lines")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<InventoryLine> getAllInventoryLine() {
	    return inventoryLineService.getAllInventoryLine();
	  }
	  //AJOUT DU VERBE GET  
	  @GetMapping("/inventory-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public InventoryLine getInventoryLineById(@PathVariable("id") Long id) {
		  InventoryLine inventoryLine = inventoryLineService.getInventoryLineById(id);

	    if (inventoryLine == null) {}
	    return inventoryLine;
	  }
	  //AJOUT DU VERBE POST 
	  @PostMapping("/inventory-line")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public Long createInvotoryLine(@RequestBody InventoryLine inventoryLine) {
	    return inventoryLineService.createInvotoryLine(inventoryLine);
	  }
	  //AJOUT DU VERBE PUT  
	  @PutMapping("/inventory-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updateInventoryLine(
	    @PathVariable Long id,@RequestBody InventoryLine inventoryLine
	  ) {
	    if (inventoryLineService.getInventoryLineById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    inventoryLineService.updateInventoryLine(id, inventoryLine);
	  }
	  @DeleteMapping("/inventory-line/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void deleteInventoryLine(@PathVariable Long id) {
	    if (inventoryLineService.getInventoryLineById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    inventoryLineService.deleteInventoryLine(id);
	  }
}
