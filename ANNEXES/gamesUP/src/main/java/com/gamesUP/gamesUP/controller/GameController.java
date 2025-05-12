package com.gamesUP.gamesUP.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamesUP.gamesUP.model.Game;
import com.gamesUP.gamesUP.services.GameService;

@RestController
public class GameController {
	@Autowired
	private GameService gameService;

    @GetMapping("/jeux")
    public List<Game> getAllJeux() {
    	return gameService.findALL();
       
    }

  //  @PostMapping
  //  public void ajouterJeu(@RequestBody Game game) {
     //   try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
         //    PreparedStatement stmt = connection.prepareStatement("INSERT INTO jeux (nom, auteur) VALUES (?, ?)")) {

      //      stmt.setString(1, game.nom);
        //    stmt.setString(2, game.auteur);
         //   stmt.executeUpdate();
    //    } catch (SQLException e) {
       //     e.printStackTrace();
     //   }
    //}
}