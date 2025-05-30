package com.gamesUP.gamesUP.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


public class Inventory {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
	    private List<InventoryLine> stock;
	
}
