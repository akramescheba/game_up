package com.gamesUP.gamesUP.services.impl;
import com.gamesUP.gamesUP.dao.AuthorRepository;
import com.gamesUP.gamesUP.dao.CategoryRepository;
import com.gamesUP.gamesUP.dao.GameRepository;
import com.gamesUP.gamesUP.dao.PublisherRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Author;
import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.model.Publisher;
import com.gamesUP.gamesUP.services.GameService;

import dto.GameDTO;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {


  @Autowired
  private GameRepository gameRepository;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private PublisherRepository publisherRepository;
 
  @Override
  public List<Game> findALL() {
    List<Game> games = new ArrayList<Game>();
    gameRepository.findAll().forEach(games::add);
    return games;
  }

  @Override
  public Game findById(Long id) {
    Optional<Game> game = gameRepository.findById(id);
    if (game.isPresent()) {
      return game.get();
    }
    throw new ExceptionEntityDontExist();
  }

  @Override
  /*METHODE D'AJOUT DE JEU*/
	    public Game ajouterJeu(GameDTO gameDTO) {
	    Game game = new Game();
	          game.setNom(gameDTO.getNom());
	          game.setImage(gameDTO.getImage());
	          game.setGenre(gameDTO.getGenre());
	          game.setDescription(gameDTO.getDescription());
	          game.setNumEdition(gameDTO.getNumEdition());
	          mapRelations(game, gameDTO);

	          return gameRepository.save(game);
	      }

	      private void mapRelations(Game game, GameDTO gameDTO) {
	          if (gameDTO.getCategoryId() != null) {
	              Category category = categoryRepository.findById(gameDTO.getCategoryId())
	                  .orElseThrow(() -> new EntityNotFoundException("La Category avec l'id " + gameDTO.getCategoryId() + " n'existe pas"));
	              game.setCategory(category);
	          }

	          if (gameDTO.getPublisherId() != null) {
	              Publisher publisher = publisherRepository.findById(gameDTO.getPublisherId())
	                  .orElseThrow(() -> new EntityNotFoundException("Le Publisher avec l'id " + gameDTO.getPublisherId() + " n'existe pas"));
	              game.setPublisher(publisher);
	          }

	          if (gameDTO.getAuthorId() != null) {
	              Author author = authorRepository.findById(gameDTO.getAuthorId())
	                  .orElseThrow(() -> new EntityNotFoundException("L'Author avec l'id  " + gameDTO.getAuthorId() + " n'existe pas"));
	              game.setAuthor(author);
	          }
	      }
	  
  @Override
  public void updatePartial(Long id, GameDTO gameDTO) {
      Game gameExistant = gameRepository.findById(id)
          .orElseThrow(() -> new ExceptionEntityDontExist());

      if (gameDTO.getNom() != null) {
          gameExistant.setNom(gameDTO.getNom());
      }

      if (gameDTO.getImage() != null) {
          gameExistant.setImage(gameDTO.getImage());
      }

      if (gameDTO.getGenre() != null) {
          gameExistant.setGenre(gameDTO.getGenre());
      }

      if (gameDTO.getDescription() != null) {
          gameExistant.setDescription(gameDTO.getDescription());
      }

      if (gameDTO.getNumEdition() != null) {
          gameExistant.setNumEdition(gameDTO.getNumEdition());
      }
      mapRelations(gameExistant, gameDTO);

      gameRepository.save(gameExistant);
  }
  
@Override
public void update(Long id, Game games) {
    Game gameExistant = gameRepository.findById(id)
        .orElseThrow(() -> new ExceptionEntityDontExist());
    gameExistant.setNom(games.getNom());
    gameExistant.setImage(games.getImage());
    gameExistant.setGenre(games.getGenre());
    gameExistant.setDescription(games.getDescription());
    gameExistant.setNumEdition(games.getNumEdition());
    gameExistant.setCategory(games.getCategory());
    gameExistant.setPublisher(games.getPublisher());
    gameRepository.save(gameExistant); 
}

@Override
public void delete(Long id) {
	gameRepository.deleteById(id);
}


}
