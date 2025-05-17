package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.PublisherRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Publisher;
import com.gamesUP.gamesUP.services.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	
	 public List<Publisher> findALL() {
	    List<Publisher> publishers = new ArrayList<Publisher>();

	    publisherRepository.findAll().forEach(publishers::add);

	    return publishers;
	  }

	@Override
	public Publisher findById(Long id) {
	    Optional<Publisher> publishers = publisherRepository.findById(id);
	    if (publishers.isPresent()) {
	      return publishers.get();
	    }
	    throw new ExceptionEntityDontExist();
	  }

	@Override
	public Long createPublisher(Publisher publisher) {
		return publisherRepository.save(publisher).getId();
	}
	  @Override
	  public void update(Long id, Publisher publishers) {
	    Publisher publisherExistante = publisherRepository.findById(id)
	      .orElseThrow(() -> new ExceptionEntityDontExist());
	    publisherExistante.setName(publishers.getName());
	    publisherRepository.save(publisherExistante);
	  }
	  @Override
	  public void delete(Long id) {
		  publisherRepository.deleteById(id);
	  	
	  }

}
