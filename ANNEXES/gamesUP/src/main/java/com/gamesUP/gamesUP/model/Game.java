package com.gamesUP.gamesUP.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


private Long id;
private String nom;
private String image;
private String description;
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

private String genre;
private Long numEdition;

@ManyToOne
@JoinColumn(name = "category_id")
@JsonBackReference("game-category")
private Category category;


@ManyToOne
@JoinColumn(name = "publisher_id")
@JsonBackReference("game-publisher")
private Publisher publisher;

@ManyToOne
@JoinColumn(name = "author_id")
private Author author;


 public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}

//Ajout des getters et setters
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

public Long getNumEdition() {
	return numEdition;
}

public void setNumEdition(Long numEdition) {
	this.numEdition = numEdition;
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



}
