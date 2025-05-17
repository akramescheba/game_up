package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Publisher;

public interface PublisherService {

	List<Publisher> findALL();

	public Publisher findById(Long id);

	public Long createPublisher(Publisher publisher);

	public void update(Long id, Publisher publishers);

	public void delete(Long id);

}
