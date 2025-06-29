package com.gamesUP.gamesUP.services;

import java.util.List;

import com.gamesUP.gamesUP.model.Wishlist;

public interface WishlistService {

	public List<Wishlist> getAllWishLists();

	public Wishlist getWishListById(Long id);

	public Long createWishlist(Wishlist wishlist);

	public void updateWishlist(Long id, Wishlist wishlists);

	public void deleteWishlist(Long id);

	public void updatePartialWishlist(Wishlist wishlistExistant, Wishlist neWishlist);



}
