package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nom;
private String auteur;
private String genre;
private Long numEdition;
@ManyToOne
private Category category;
@ManyToOne
private Publisher publisher;


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
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
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
