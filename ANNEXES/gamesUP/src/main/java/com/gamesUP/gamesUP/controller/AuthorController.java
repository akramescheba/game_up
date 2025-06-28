package com.gamesUP.gamesUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Author;
import com.gamesUP.gamesUP.services.AuthorService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, allowedHeaders = "*")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @GetMapping("/authors")
  @ResponseStatus(code = HttpStatus.OK)
  public List<Author> getAllAuthors() {
    return authorService.getAllAuthor();
  }

  //AJOUT DU VERBE GET - POUR AFFICHER UN AUTHOR PAR ID
  @GetMapping("/author/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Author getAuthorById(@PathVariable("id") Long id) {
    Author author = authorService.getAuthorById(id);

    if (author == null) {}
    return author;
  }

  //AJOUT DU VERBE POST  - AJOUTER UN AUTHOR
  @PostMapping("/author")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Long createAuthor(@RequestBody Author author) {
    return authorService.ajouterAuthor(author);
  }

  //AJOUT DU VERBE PATCH  - MODIFIER UN AUTHOR PAR ID
  @PatchMapping("author/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updatePartialAuthor(
    @PathVariable Long id,
    @RequestBody Author newAuthor
  ) {
    Author authorExistant = authorService.getAuthorById(id);

    if (authorExistant == null) {
      throw new ExceptionEntityDontExist();
    }
    authorService.updatePartialAuthor(authorExistant, newAuthor);
  }

  //AJOUT DU VERBE PUT  - MODIFIER UN AUTHOR PAR ID
  @PutMapping("/author/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updateAuthor(@PathVariable Long id, @RequestBody Author author) {
    if (authorService.getAuthorById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    authorService.updateAuthor(id, author);
  }

  //AJOUT DU VERBE DELETE  - SUPPRIMER UN AUTHOR
  @DeleteMapping("/author/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void deleteAuthor(@PathVariable Long id) {
    if (authorService.getAuthorById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    authorService.deleteAuthor(id);
  }
}
