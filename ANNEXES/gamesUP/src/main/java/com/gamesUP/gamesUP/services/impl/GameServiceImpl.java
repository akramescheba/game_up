package com.gamesUP.gamesUP.services.impl;

import com.gamesUP.gamesUP.dao.GameRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.services.GameService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

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
  public Long ajouterJeu(Game game) {
    return gameRepository.save(game).getId();
  }

  @Override
  public void updatePartial(Game gameExistant, Game newGame) {
    if (newGame.getNom() != null) {
      gameExistant.setNom(newGame.getNom());
    }
    if (newGame.getAuteur() != null) {
      gameExistant.setAuteur(newGame.getAuteur());
    }
    if (newGame.getGenre() != null) {
      gameExistant.setGenre(newGame.getGenre());
    }
    if (newGame.getNumEdition() != null) {
      gameExistant.setNumEdition(newGame.getNumEdition());
    }
    if (newGame.getCategory() != null) {
        gameExistant.setCategory(newGame.getCategory());
      }
    if (newGame.getPublisher() != null) {
        gameExistant.setPublisher(newGame.getPublisher());
      }
    gameRepository.save(gameExistant);
  }

@Override
public void update(Long id, Game games) {
    Game gameExistant = gameRepository.findById(id)
        .orElseThrow(() -> new ExceptionEntityDontExist());
    gameExistant.setNom(games.getNom());
    gameExistant.setAuteur(games.getAuteur());
    gameExistant.setGenre(games.getGenre());
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
