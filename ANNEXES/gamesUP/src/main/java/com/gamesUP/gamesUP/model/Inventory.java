package com.gamesUP.gamesUP.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<InventoryLine> stock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<InventoryLine> getStock() {
        return stock;
    }

    public void setStock(List<InventoryLine> stock) {
        this.stock = stock;
    }
}