package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="avis")
public class Avis {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int note;
private String commentaire;
	
//Ajout des getters et setters

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNote() {
	return note;
}
public void setNote(int note) {
	this.note = note;
}
public String getCommentaire() {
	return commentaire;
}
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}

}
