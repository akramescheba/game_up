package com.gamesUP.gamesUP.dao;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.InventoryLine;
import com.gamesUP.gamesUP.services.InventoryLineService;




@DataJpaTest
@ActiveProfiles("test")
public class InventoryLineRepositoryTest {
    
    @Autowired
    private InventoryLineService inventoryLineService ;
  
    @Test
    void shouldGetAllInvotoryLine() {
    	List<InventoryLine> inventoryLines = inventoryLineService.getAllInventoryLine();
    	assertEquals(1, inventoryLines.size());    	
    }
    @Test
    void shoulGetInventoryLineById() {
    	InventoryLine inventoryLine =inventoryLineService.getInventoryLineById(1L);
    	assertEquals(1, inventoryLine.getId()); 
    	assertEquals(1, inventoryLine.getQuantity());  	
    };
    @Test
    void shouldCreateInventoryLine() {
    	InventoryLine newInventoryLine = new InventoryLine();
    	newInventoryLine.setId(1L);
    	inventoryLineService.createInvotoryLine(newInventoryLine);
    	assertEquals(1L, newInventoryLine.getId());
    };
    @Test
    void shouldUpdateInventoryLine() {
    	InventoryLine inventoryLine = inventoryLineService.getInventoryLineById(1L);
    	InventoryLine newInventoryLine = new InventoryLine();
    	newInventoryLine.setId(1L);
    	inventoryLineService.updateInventoryLine(1L, newInventoryLine);
        assertEquals(1L, inventoryLine.getId());
    };
    @Test
    void shouldDeleteInventoryLine() {
    InventoryLine inventoryLine=inventoryLineService.getInventoryLineById(1L);
    inventoryLine.setId(1L);
    inventoryLineService.deleteInventoryLine(1L);
    assertEquals(1L, inventoryLine.getId());
    };

}
