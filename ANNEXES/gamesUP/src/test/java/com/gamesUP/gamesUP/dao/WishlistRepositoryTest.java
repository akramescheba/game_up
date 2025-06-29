package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Wishlist;
import com.gamesUP.gamesUP.services.impl.WishlistServiceImpl;

@DataJpaTest
@ActiveProfiles("test")
public class WishlistRepositoryTest {
	@Autowired
	private WishlistServiceImpl wishlistServiceImpl;

    @Test
	void shouldGetAllCategories() {
		List<Wishlist> wishlists = wishlistServiceImpl.getAllWishLists();
		assertEquals(1, wishlists.size());
	}

	// Test GeById
	// @Test
	void shouldGetWhishlistById() {
		Wishlist wishlists = wishlistServiceImpl.getWishListById((long) 1);
		assertEquals("wishlist", wishlists.getName());
	};

	// Test Post
	@Test
	void shouldCreateWishlist() {

		Wishlist newWishlist = new Wishlist();
		newWishlist.setName("wishlist");
		assertEquals("wishlist", newWishlist.getName());
	}

	// Test UpdatePartial
		 @Test
		void shouldUpdatePartialWishlist() {
			Wishlist wishlistExistant = wishlistServiceImpl.getWishListById(1L);
			Wishlist newWishlist = new Wishlist();
			newWishlist.setName("wishlist");
			wishlistServiceImpl.updatePartialWishlist( wishlistExistant, newWishlist);
		}
		
	// Test Update
	@Test
	void shouldUpdateWishlist() {
		Wishlist wishlistExistant = wishlistServiceImpl.getWishListById(1L);
		Wishlist newWishlist = new Wishlist();
		newWishlist.setName("wishlist");
		wishlistServiceImpl.updateWishlist(1L, wishlistExistant);
	}

	// Test delete
	@Test
	void shouldDeleteWishlist() {
		wishlistServiceImpl.deleteWishlist((long) 1);
	};
}
