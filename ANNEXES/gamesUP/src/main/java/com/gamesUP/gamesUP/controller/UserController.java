package com.gamesUP.gamesUP.controller;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.User;
import com.gamesUP.gamesUP.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  //AJOUT DU VERBE GET - POUR AFFICHER LES TOUS USERs
  @GetMapping("/users")
  @ResponseStatus(code = HttpStatus.OK)
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  //AJOUT DU VERBE GET  - POUR AFFICHER LES USERs PAR ID
  @GetMapping("/user/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public User getUserById(@PathVariable("id") Long id) {
    User user = userService.getUserById(id);

    if (user == null) {}
    return user;
  }

  //AJOUT DU VERBE POST - AJOUTER UN USER
  @PostMapping("/user")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Long createUser(@RequestBody User user) {
    return userService.createUser(user);
  }
  
  //AJOUT DU VERBE PUT  - MODIFIER UN USER PAR ID
  @PutMapping("/user/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updateUser(@PathVariable Long id, @RequestBody User users) {
    if (userService.getUserById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    userService.updateUser(id, users);
  }
  
  //AJOUT DU VERBE PUT  - MODIFIER UN CHAMP PRECIS DU USER PAR ID
  @PatchMapping("/user/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updatePartialUser(@PathVariable Long id, @RequestBody User newUser) {
    User userExistant = userService.getUserById(id);

    if (userExistant == null) {
      throw new ExceptionEntityDontExist();
    }
    userService.updatePartialUser(userExistant, newUser);
  }
  
  //AJOUT DU VERBE DELETE  - SUPPRIMER UN USER
  @DeleteMapping("/user/{id}")
  @ResponseStatus(code=HttpStatus.OK)
  public void deleteUser(@PathVariable Long id) {
	  if (userService.getUserById(id) == null) {
	      throw new ExceptionEntityDontExist();
	    }
	  userService.deleteUser(id);

	  }
}
