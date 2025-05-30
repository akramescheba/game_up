package com.gamesUP.gamesUP.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//Ajoute du décorateur Entity
@Entity
@Table(name = "author")
public class Author {
	//Ajoute du décorateur ID et Generatedvalue
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Game> games;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}





}
