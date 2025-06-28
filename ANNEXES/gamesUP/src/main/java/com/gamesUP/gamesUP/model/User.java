package com.gamesUP.gamesUP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur") 
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnoreProperties("user")
	private Long id;
    private String nom;
	private String email;
    private String role;
	private String password;
    private String repassword;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wishlist wishlist;
    
	 /*AJOUT DES GETTERS ET SETTERS*/
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
	 public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	    public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRepassword() {
			return repassword;
		}
		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}
		public Wishlist getWishlist() {
			return wishlist;
		}
		public void setWishlist(Wishlist wishlist) {
			this.wishlist = wishlist;
		}
		
}
