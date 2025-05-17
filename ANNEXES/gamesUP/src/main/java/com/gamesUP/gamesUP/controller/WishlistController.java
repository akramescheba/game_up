package com.gamesUP.gamesUP.controller;

import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Wishlist;
import com.gamesUP.gamesUP.services.WishlistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

  @Autowired
  private WishlistService wishlistService;

  //AJOUT DU VERBE GET - POUR AFFICHER LES TOUTE LA LISTE DES SOUHAITS
  @GetMapping("/wishlists")
  @ResponseStatus(code = HttpStatus.OK)
  public List<Wishlist> getAllWishList() {
    return wishlistService.getAllWishLists();
  }

  //AJOUT DU VERBE GET  - POUR AFFICHER UNE LISTE DES SOUHAITS PAR ID
  @GetMapping("/wishlist/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Wishlist getWishlistyId(@PathVariable("id") Long id) {
    Wishlist wishlist = wishlistService.getWishListById(id);

    if (wishlist == null) {}
    return wishlist;
  }

  //AJOUT DU VERBE POST  - AJOUTER UNE LISTE DES SOUHAITS
  @PostMapping("/wishlist")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Long createWishlist(@RequestBody Wishlist wishlist) {
    return wishlistService.createWishlist(wishlist);
  }

  //AJOUT DU VERBE PUT  - AJOUTER UNE LISTE DES SOUHAITS
  @PutMapping("/wishlist/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void updateWishList(
    @PathVariable Long id,
    @RequestBody Wishlist wishlists
  ) {
    if (wishlistService.getWishListById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    wishlistService.updateWishlist(id, wishlists);
  }

  //AJOUT DU VERBE DELETE  - SUPPRIMER UNE LISTE DES SOUHAITS
  @DeleteMapping("/wishlist/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void deleteWishlist(@PathVariable Long id) {
    if (wishlistService.getWishListById(id) == null) {
      throw new ExceptionEntityDontExist();
    }
    wishlistService.deleteWishlist(id);
  }
}
