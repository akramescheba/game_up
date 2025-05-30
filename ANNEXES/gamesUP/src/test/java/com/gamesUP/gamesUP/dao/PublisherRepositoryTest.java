package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.gamesUP.gamesUP.model.Publisher;
import com.gamesUP.gamesUP.services.impl.PublisherServiceImpl;

@DataJpaTest
@ActiveProfiles("test")
public class PublisherRepositoryTest {
	  @Autowired
	  private PublisherServiceImpl publisherServiceImpl;
	  @Test
	  void shouldGetAllPublisher() {
	    List<Publisher> publisher = publisherServiceImpl.findALL();
	    assertEquals(1, publisher.size());
	  }
		//Test GeById
	    @Test
	    void shouldGetPublisherById() {
	    	Publisher publisher = publisherServiceImpl.findById((long) 1);
	  	  assertEquals("Jordy AKRA MESCHEBA", publisher.getName());
	    };
	    //Test Post
	    @Test
	    void shouldCreatePublisher() {
	    	Publisher newPublisher = new Publisher();
	    	newPublisher.setName("Jordy AKRA MESCHEBA");
	      assertEquals("Jordy AKRA MESCHEBA", newPublisher.getName());
	    }
	    @Test
	    void shouldUpdatePublisher() {
	    	Publisher publisher= publisherServiceImpl.findById(1L);
	    	Publisher newPublisher = new Publisher();
	    	newPublisher.setName("Jordy AKRA MESCHEBA");
	    	publisherServiceImpl.update(1L, publisher);
	    }
	    //Test delete
	    @Test
	    void shouldDeletePublisher() {
	    	publisherServiceImpl.delete((long) 1);
	  	};
		
}
