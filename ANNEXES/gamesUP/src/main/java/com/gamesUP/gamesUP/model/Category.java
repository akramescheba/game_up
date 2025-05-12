package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String type;
	 //Ajout des getters et setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
