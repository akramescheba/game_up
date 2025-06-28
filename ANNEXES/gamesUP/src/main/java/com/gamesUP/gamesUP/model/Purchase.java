package com.gamesUP.gamesUP.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Ajout d'un ID
    private Long id;
    private Date date;
    private boolean paid;
    private boolean delivered;
    private boolean archived;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseLine> line;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Ajout des getters et setters
    public User getUser() {
    	return user;
    }
    public void setUser(User user) {
    	this.user = user;
    }
    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public List<PurchaseLine> getLine() {
        return line;
    }

    public void setLine(List<PurchaseLine> line) {
        this.line = line;
    }

	
}
