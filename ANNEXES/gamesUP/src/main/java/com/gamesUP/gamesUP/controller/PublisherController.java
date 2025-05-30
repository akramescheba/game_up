package com.gamesUP.gamesUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Publisher;
import com.gamesUP.gamesUP.services.PublisherService;

@RestController
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class PublisherController {
	@Autowired
	PublisherService publisherService;
	
	  @GetMapping("/publishers")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Publisher> getAllPublisher() {
	    return publisherService.findALL();
	  }

	  @GetMapping("/publisher/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public Publisher getGameById(@PathVariable("id") Long id) {
		  Publisher publishers = publisherService.findById(id);

	    if (publishers == null) {}
	    return publishers;
	  }
	  @PostMapping("/publisher")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public Long createPublisher(@RequestBody Publisher publisher) {
	    return publisherService.createPublisher(publisher);
	  }
	  @PutMapping("/publisher/{id}")
	  @ResponseStatus(code = HttpStatus.OK)
	  public void updatePublisher(@PathVariable Long id, @RequestBody Publisher publishers) {
	    if (publisherService.findById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    publisherService.update(id, publishers);
	  }
	  @DeleteMapping("/publisher/{id}")
	  @ResponseStatus(code=HttpStatus.OK)
	  public void deleteGame(@PathVariable Long id) {
		  if (publisherService.findById(id) == null) {
		      throw new ExceptionEntityDontExist();
		    }
		  publisherService.delete(id);

		  }


}
