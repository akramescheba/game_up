package com.gamesUP.gamesUP.model;
import java.util.List;




public class Author {

	
	public Long id;
    
    public String name;
    
    public List<Game> games;

  //Ajout des getters et setters
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
