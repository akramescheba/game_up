package com.gamesUP.gamesUP.dao;

import org.springframework.data.repository.CrudRepository;

import com.gamesUP.gamesUP.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
