package com.gamesUP.gamesUP.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesUP.gamesUP.dao.GameRepository;
import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.services.GameService;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameRepository gameRepository;

	@Override
	public List<Game> findALL() {
		return (List<Game>) gameRepository.findAll();
		}


}
