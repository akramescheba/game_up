package com.gamesUP.gamesUP.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



/*LES VUES AUTORISEES*/
@Entity
@Table(name = "author")
public class Author {
	/*LES VUES AUTORISEES*/
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	 
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("author")
    private List<Game> games ;
    
    public Author() {};
    
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
