package com.gamesUP.gamesUP.services.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamesUP.gamesUP.dao.WishlistRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Wishlist;
import com.gamesUP.gamesUP.services.WishlistService;


@Service
public class WishlistServiceImpl implements WishlistService{

    @Autowired
    private WishlistRepository wishlistRepository;

	@Override
	public List<Wishlist> getAllWishLists() {
		   List<Wishlist> wishlists = new ArrayList<Wishlist>();

		   wishlistRepository.findAll().forEach(wishlists::add);

		    return wishlists;
		  }

	@Override
	public Wishlist getWishListById(Long id) {
		   Optional<Wishlist> wishlist = wishlistRepository.findById(id);
		    if (wishlist.isPresent()) {
		      return wishlist.get();
		    }
		    throw new ExceptionEntityDontExist();
		  }
	
	  @Override
	  public Long createWishlist(Wishlist wishlist) {
	    return wishlistRepository.save(wishlist).getId();
	  }

	@Override
	public void updateWishlist(Long id, Wishlist wishlists) {
		Wishlist wishlistExistant = wishlistRepository.findById(id)
	            .orElseThrow(() -> new ExceptionEntityDontExist());
		wishlistExistant.setName(wishlists.getName());
		wishlistRepository.save(wishlistExistant); 
	    }

	@Override
	public void deleteWishlist(Long id) {
		wishlistRepository.deleteById(id);
		}

	@Override
	public void updatePartialWishlist(Wishlist wishlistExistant, Wishlist neWishlist) {
		if (neWishlist.getName() != null) {
			wishlistExistant.setName(neWishlist.getName());
		}wishlistRepository.save(wishlistExistant);
		
	}

	}


