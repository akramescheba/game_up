package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.UserRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.User;
import com.gamesUP.gamesUP.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		   List<User> users = new ArrayList<User>();

		   userRepository.findAll().forEach(users::add);

		    return users;
		  }

	@Override
	public User getUserById(Long id) {
	    Optional<User> user = userRepository.findById(id);
	    if (user.isPresent()) {
	      return user.get();
	    }
	    throw new ExceptionEntityDontExist();
	  }

	@Override
	public Long createUser(User user) {	
		return userRepository.save(user).getId();
	}

	@Override
	public void updateUser(Long id, User users) {

		    User userExistant = userRepository.findById(id)
		        .orElseThrow(() -> new ExceptionEntityDontExist());
		    userExistant.setNom(users.getNom());
		    userRepository.save(userExistant); 
		}

	@Override
	public void updatePartialUser(User userExistant, User newUser) {
	    if (userExistant.getNom() != null) {
	    	userExistant.setNom(newUser.getNom());
	      }
	  userRepository.save(userExistant);
		
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	
	
	}
	


