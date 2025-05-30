package com.gamesUP.gamesUP.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class InventoryLine {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToAny
	    @JoinColumn(name = "inventory_id")
	    private Inventory inventory;

	    @ManyToAny
	    @JoinColumn(name = "game_id")
	    private Game game;

	    private int quantity;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Inventory getInventory() {
			return inventory;
		}

		public void setInventory(Inventory inventory) {
			this.inventory = inventory;
		}

		public Game getGame() {
			return game;
		}

		public void setGame(Game game) {
			this.game = game;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    

}
