package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.User;

public interface UserService {

	List<User> getAllUsers();

	public User getUserById(Long id);

	public Long createUser(User user);

	public void updateUser(Long id, User users);

	public void updatePartialUser(User userExistant, User newUser);

	public void deleteUser(Long id);



	

}
