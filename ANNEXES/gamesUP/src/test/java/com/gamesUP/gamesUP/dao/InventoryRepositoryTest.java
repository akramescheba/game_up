package com.gamesUP.gamesUP.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Inventory;
import com.gamesUP.gamesUP.services.InventoryService;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class InventoryRepositoryTest {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Test
	void souldGetALLInventory() {
	Inventory inventory = new Inventory();
	inventory.setId(1L);
		List<Inventory> inventorie = inventoryService.getAllInventory();
		 assertNotNull(inventorie);
		assertEquals(1L, inventorie.size());
	};
	@Test
	void shouldGetInventoryById() {
		Inventory inventory = new Inventory();
		inventory.setId(1L);
		inventory = inventoryService.getInventoryById(1L);
		assertEquals(1, inventory.getId());
		};
		
	@Test
	void shouldCreateInventory() {
		Inventory newInventory = new Inventory();
		newInventory.setId(1L);
		inventoryService.createInvotory(newInventory);
		assertEquals(1L, newInventory.getId());
	};
	@Test
	void shouldUpdateInventory() {
		Inventory inventory = inventoryService.getInventoryById(1L);
		Inventory newInventory = new Inventory();
		newInventory.setId(1L);
		inventoryService.updateInventory(1L, newInventory);
		assertEquals(1L, inventory.getId());
		
	};
	
;	@Test
	void shouldHaveDeleteInventory() {
		Inventory inventory = inventoryService.getInventoryById(1L);
		inventory.setId(1L);
		inventoryService.deleteInventory(1L);
		assertEquals(1L, inventory.getId());
	};
}
