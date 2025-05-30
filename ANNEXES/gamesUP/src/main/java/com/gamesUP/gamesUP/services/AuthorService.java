package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Author;

public interface AuthorService {

	public List<Author> getAllAuthor();

	public Author getAuthorById(Long id);

	public void updateAuthor(Long id, Author author);

	public Long ajouterAuthor(Author author);

	public void deleteAuthor(Long id);

}
