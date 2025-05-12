package com.gamesUP.gamesUP.model;

import java.util.HashMap;


public class Inventory {
	 //Ajout des getters et setters
	public HashMap<Game, Integer> getStock() {
		return stock;
	}

	public void setStock(HashMap<Game, Integer> stock) {
		this.stock = stock;
	}

	HashMap<Game, Integer> stock;
	
}
