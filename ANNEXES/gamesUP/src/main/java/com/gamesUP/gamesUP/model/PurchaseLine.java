package com.gamesUP.gamesUP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class PurchaseLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int utilisateurId;
    private int jeuId;
    private double prix;
    private double rating;
    
    @ManyToOne

    private Game game;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;


	//Ajout des getters et setters
	 public double getRating() {
		 return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public int getJeuId() {
		return jeuId;
	}

	public void setJeuId(int jeuId) {
		this.jeuId = jeuId;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	


}
