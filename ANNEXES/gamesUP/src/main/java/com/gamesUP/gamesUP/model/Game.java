package com.gamesUP.gamesUP.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "game")

public class Game {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;
private String nom;
private String image;
private String description;
private String genre;
private Integer numEdition;

@ManyToOne
@JsonIgnoreProperties("games")
private Category category;

@ManyToOne
@JsonIgnoreProperties("games")
private Publisher publisher;

@ManyToOne
@JsonIgnoreProperties("games")
private Author author;

@ManyToOne
@JsonIgnoreProperties("games")
private Wishlist wishlist;


/*AJOUT DES GETTERS ET SETTERS*/
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}
public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}


public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}


public Integer getNumEdition() {
	return numEdition;
}

public void setNumEdition(Integer numEdition) {
	this.numEdition = numEdition;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public Publisher getPublisher() {
	return publisher;
}

public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}
public Wishlist getWishlist() {
	return wishlist;
}
public void setWishlist(Wishlist wishlist) {
	this.wishlist = wishlist;
}





}
