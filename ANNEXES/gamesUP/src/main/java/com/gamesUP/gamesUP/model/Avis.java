package com.gamesUP.gamesUP.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="avis")
public class Avis {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private int note;
/*AJOUT DES CHAMPS NAME ET DATE POUR  RECUPERER LES INFOS EN TEMPS REEL DE L'UTILISATEUR QUI A FAIT UN COMMENTAIRE POUR L'AFFICHAGE*/
private String name;
@JsonFormat(pattern="dd-MM-yy à HH:mm ")
@Transient
private LocalDateTime date;
private String commentaire;

public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

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
