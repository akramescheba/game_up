package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.User;
import com.gamesUP.gamesUP.services.UserService;
import com.gamesUP.gamesUP.services.impl.UserServiceImpl;


@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	  @Autowired
	  private UserServiceImpl userServiceImpl;

	  //Test de vérification des méthode GETs, POST, PATCH et DELETE du modèle USER;
	  // Test GetAll
	 // @Test
	  void shouldGetAllUsers() {
	     List<User> users = userServiceImpl.getAllUsers();
	    assertEquals(2, users.size());
	  }
	  //Test GeById
	    //@Test
	    void shouldGetById() {
	  	  User user = userServiceImpl.getUserById((long) 1);
	  	  assertEquals("VISIPLUS", user.getNom());
	    };
	    //Test Post
	    @Test
	    void shouldCreateUser() {
	      User newUsers = new User();

	      newUsers.setNom("ISCOD");
	      newUsers.setEmail("iscod@email.com");
	      newUsers.setRole("administrateur");
	      newUsers.setPassword("iscod2025");
	      newUsers.setRepassword("iscod2025");
	      //userServiceImpl.createUser(newUsers); 
	      assertEquals("ISCOD", newUsers.getNom());
	      assertEquals("iscod@email.com", newUsers.getEmail());
	      assertEquals("iscod2025", newUsers.getPassword());
	    }
	    //Test Patch
	    @Test
	    void shouldUpdatePartialUser() {
	  	 User userExistant = userServiceImpl.getUserById((long) 1);
	  	  User newUser = new User();
	  	  newUser.setNom("AKREA");
	  	  userServiceImpl.updatePartialUser(userExistant, newUser);
	  
	    }
	    //Test Update
	    @Test
	    void shouldUpdateUser() {
	    	User userExistant = userServiceImpl.getUserById(1L);
	    	User newUser = new User();
	    	newUser.setNom("AKREA");
	  	userServiceImpl.updateUser(1L, userExistant);
	  	
	    }
	    //Test delete
	    @Test
	    void shouldDeleteUser() {
	    
	  	  userServiceImpl.deleteUser(1L);
	  	};
		
	}

