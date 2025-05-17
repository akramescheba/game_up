package com.gamesUP.gamesUP.controller;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping("/jeux")
  @ResponseStatus(code = HttpStatus.OK)
  public List<Game> getAllGame() {
    return gameService.findALL();
  }

  @GetMapping("/jeu/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Game findGameById(@PathVariable("id") Long id) {
    Game game = gameService.findById(id);

    if (game == null) {}
    return game;
  }

  @PostMapping("/jeu")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Long createGame(@RequestBody Game game) {
    return gameService.ajouterJeu(game);
  }

  @PutMapping("/jeu/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updateGame(@PathVariable Long id, @RequestBody Game games) {
    if (gameService.findById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    gameService.update(id, games);
  }

  @PatchMapping("/jeu/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updatePartialGame(@PathVariable Long id, @RequestBody Game newGame) {
    Game gameExistant = gameService.findById(id);

    if (gameExistant == null) {
      throw new ExceptionEntityDontExist();
    }
    gameService.updatePartial(gameExistant, newGame);
  }
  @DeleteMapping("/jeu/{id}")
  @ResponseStatus(code=HttpStatus.OK)
  public void deleteGame(@PathVariable Long id) {
	  if (gameService.findById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	  gameService.delete(id);

	  }

	  
  }

