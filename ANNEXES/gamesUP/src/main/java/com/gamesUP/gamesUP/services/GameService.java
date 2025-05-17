package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Game;

public interface GameService {

	public List<Game> findALL();

	public Game findById(Long id);
	
	public Long ajouterJeu(Game game);

	public void updatePartial(Game gameExistant, Game newGame);

	public void update(Long id, Game game);

	public void delete(Long id);





}
