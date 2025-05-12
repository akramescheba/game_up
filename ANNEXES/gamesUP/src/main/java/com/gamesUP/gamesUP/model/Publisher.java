package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Publisher {

	@Id
	String name;
	 //Ajout des getters et setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
