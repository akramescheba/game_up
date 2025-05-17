package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Avis;

public interface AvisService {

	public List<Avis> getAllAvis();

	public Avis getAvisById(int id);

	public void updateAvis(int id, Avis avis);

	public int createAvis(Avis avis);

	public void deleteAvis(int id);

}
