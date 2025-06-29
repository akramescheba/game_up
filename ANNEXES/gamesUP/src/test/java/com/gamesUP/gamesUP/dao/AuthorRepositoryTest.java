package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Author;
import com.gamesUP.gamesUP.services.impl.AuthorServiceImpl;

@DataJpaTest
@ActiveProfiles("test")
public class AuthorRepositoryTest {
	  @Autowired
	  private AuthorServiceImpl authorServiceImpl;
	  @Test
	  void shouldGetAllAuthor() {
	    List<Author> author = authorServiceImpl.getAllAuthor();
	    assertEquals(1, author.size());
	  }
	  //Test GeById
	    @Test
	    void shouldGetAuthorById() {
	  	  Author author = authorServiceImpl.getAuthorById((long) 1);
	  	  assertEquals("auteur", author.getName());
	    };
	    //Test Post
	    @Test
	    void shouldCreateAuthor() {
	      Author newAuthor = new Author();
	      newAuthor.setName("auteur");
	      assertEquals("auteur", newAuthor.getName());
	    }
	    //Test Update
	    @Test
	    void shouldUpdateAuthor() {
	    	Author userAuthor = authorServiceImpl.getAuthorById(1L);
	    	Author newAuthor = new Author();
	    	newAuthor.setName("auteur");
	    	authorServiceImpl.updateAuthor(1L, userAuthor);
	    }
	    @Test
	    void shouldUpdatePartialAuthor() {
	    	Author userAuthorExisting = authorServiceImpl.getAuthorById(1L);
	    	Author newAuthor = new Author();
	    	newAuthor.setName("auteur");
	    	authorServiceImpl.updatePartialAuthor(userAuthorExisting, newAuthor);
	    }
	    //Test delete
	    @Test
	    void shouldDeleteAuthor() {
	    	authorServiceImpl.deleteAuthor((long) 1);
	  	};
		
}
