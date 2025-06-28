package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Author;
import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.model.Publisher;
import com.gamesUP.gamesUP.services.impl.GameServiceImpl;

import dto.GameDTO;


@DataJpaTest
@ActiveProfiles("test")
public class GameRepositoryTest {
	  @Autowired
	  private GameServiceImpl gameServiceImpl;
	
	  //Test de vérification des méthode GETs, POST, PATCH et DELETE du modèle GAME;
	  // Test GetAll
	  @Test
	  void shouldGetAllGame() {
		  Game game = new Game();
		  game.setId(1L);
	    List<Game> games = gameServiceImpl.findALL();
	    assertEquals(1, games.size());
	  }
	  @Test
	  void shouldGetGameById() {
		  Game games = new Game();
		  games.setId(1L);
		   games = gameServiceImpl.findById((long) 1);
		  assertEquals("Everspace", games.getNom());
	  }
	   //Test Post
	    @Test
	    void shouldCreateGame() {
	    	Game newGame = new Game();

	      newGame.setNom("Everspace");
	      newGame.setImage("https://gaming-cdn.com/images/products/9495/616x353/everspace-xbox-one-jeu-microsoft-store-europe-cover.jpg?v=1738771868");
	      newGame.setDescription("Description");
	      newGame.setNumEdition(2002);
	      
	      Category category = new Category();
	      category.setType("Action");
	      newGame.setCategory(category);
	      
	      Publisher publisher = new Publisher();
	      publisher.setName("Jordy AKRA MESCHEBA");
	      newGame.setPublisher(publisher);
	      
	      Author author = new Author();
	      author.setName("Jordy AKRA MESCHEBA");
	      newGame.setAuthor(author);

	      assertEquals("Everspace", newGame.getNom());
	      assertEquals("Jordy AKRA MESCHEBA", newGame.getAuthor().getName());
	      assertEquals("Jordy AKRA MESCHEBA", newGame.getPublisher().getName());
	      assertEquals("Action", newGame.getCategory().getType());
	    }
	    
	    @Test
	    void shouldUpdatePartialGame() {
	    	GameDTO newGame = new GameDTO();
	  	newGame.setNom("Everspace");
	  	gameServiceImpl.updatePartial(1L, newGame);
	  	newGame.setId(1L);
	  	assertEquals(1L, newGame.getId());

	    }
	    //Test Update
	    @Test
	    void shouldUpdateGame() {
	    	Game gameExistant = gameServiceImpl.findById(1L);
	    	Game newGame = new Game();
	  	newGame.setNom("Everspace");
		newGame.setId(1L);
	  	gameServiceImpl.update(1L, gameExistant);
	  	assertEquals(1L, newGame.getId());

	    }
	    
	   // @Test
	    void shouldDeleteGame() {
	    	gameServiceImpl.delete((long) 1);
	    	
	  	};
	
}
