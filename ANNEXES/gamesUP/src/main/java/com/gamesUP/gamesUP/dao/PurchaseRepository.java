package com.gamesUP.gamesUP.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gamesUP.gamesUP.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long>{

	List<Purchase> findUserById(Long userId);

}
