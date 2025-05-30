package com.gamesUP.gamesUP.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.AuthorRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Author;
import com.gamesUP.gamesUP.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	 @Autowired
	    private AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthor() {
		List<Author> author = new ArrayList<Author>();
		authorRepository.findAll().forEach(author::add);
		return author;
	}

	@Override
	public Author getAuthorById(Long id) {
		  Optional<Author> author = authorRepository.findById(id);
		    if (author.isPresent()) {
		      return author.get();
		    }
		    throw new ExceptionEntityDontExist();
		  }

	@Override
	public void updateAuthor(Long id, Author author) {
		   Author authorExistant = authorRepository.findById(id)
			        .orElseThrow(() -> new ExceptionEntityDontExist());
		   authorExistant.setName(author.getName());
		   authorExistant.setGames(author.getGames());
		   authorRepository.save(authorExistant);
		
	}

	@Override
	public Long ajouterAuthor(Author author) {
		
		return  authorRepository.save(author).getId();
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}

}
