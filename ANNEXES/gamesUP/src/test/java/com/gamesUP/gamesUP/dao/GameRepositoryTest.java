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


@DataJpaTest
@ActiveProfiles("test")
public class GameRepositoryTest {
	  @Autowired
	  private GameServiceImpl gameServiceImpl;

	  //Test de vérification des méthode GETs, POST, PATCH et DELETE du modèle GAME;
	  // Test GetAll
	  @Test
	  void shouldGetAllGame() {
	    List<Game> game = gameServiceImpl.findALL();
	    assertEquals(1, game.size());
	  }
	  @Test
	  void shouldGetGameById() {
		  Game game = gameServiceImpl.findById((long) 1);
		  assertEquals("Everspace", game.getNom());
	  }
	   //Test Post
	    @Test
	    void shouldCreateGame() {
	    	Game newGame = new Game();

	      newGame.setNom("Everspace");
	      newGame.setImage("https://gaming-cdn.com/images/products/9495/616x353/everspace-xbox-one-jeu-microsoft-store-europe-cover.jpg?v=1738771868");
	      newGame.setDescription("Description");
	      newGame.setNumEdition(2002L);
	      
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
	    //Test Update
	    @Test
	    void shouldUpdateGame() {
	    	Game gameExistant = gameServiceImpl.findById(1L);
	    	Game newGame = new Game();
	  	newGame.setNom("Everspace");
	  	gameServiceImpl.update(1L, gameExistant);
	    }
	    
	    @Test
	    void shouldDeleteGame() {
	    	gameServiceImpl.delete((long) 1);
	  	};
	   @Test
	   void shouldUpdatePartialGame() {
		   Game gameExistant = gameServiceImpl.findById((long) 1);
		   Game newGame = new Game();
		   newGame.setNom("Mortal komba");
		   gameServiceImpl.updatePartial( gameExistant, newGame);
		   
	   }
}
