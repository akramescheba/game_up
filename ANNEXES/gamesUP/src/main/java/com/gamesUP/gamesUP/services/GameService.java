package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.model.Game;

import dto.GameDTO;

public interface GameService {

	public List<Game> findALL();

	public Game findById(Long id);

	public void update(Long id, Game game);

	public void delete(Long id);

    public Game ajouterJeu(GameDTO gameDTO);

    public void updatePartial(Long id, GameDTO gameDTO);

	

















}
