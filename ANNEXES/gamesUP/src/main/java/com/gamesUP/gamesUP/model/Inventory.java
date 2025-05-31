package com.gamesUP.gamesUP.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inventory {
	
	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<InventoryLine> getStock() {
		return stock;
	}

	public void setStock(List<InventoryLine> stock) {
		this.stock = stock;
	}

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
	    private List<InventoryLine> stock;
	
}
