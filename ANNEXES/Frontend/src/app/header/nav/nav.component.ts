import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import {AuthorService} from '../../services/author.service';
import  {GameList, Author} from '../../models/models'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.scss',
})
export class NavComponent {
  logo = 'assets/logo.png';
    selectedAuthor: Author | null = null;
  selectedGame: GameList | null = null;

    ListAuthor: Author[] = [];


  constructor(private router: Router, private authService: AuthService,    private authorService: AuthorService,) {}

  gameList: GameList[]=[];
  searchKeyWord: string = '';
  pageActive: string = 'client';
  searchGames(): GameList[]{
    if(!this.searchKeyWord) return this.gameList;
    const keyWord = this.searchKeyWord.toLowerCase();
    return this.gameList.filter((game)=>{
      game.nom.toLowerCase().includes(keyWord)
    })

  }
  selectedAuthorId(author: Author): void{
    this.selectedAuthor = {...author};
  }

    /*METHODE DE GET D'UN AUTHOR */
  getAllAuthors() {
    this.authorService.getAllAuthors().subscribe((data) => {
      this.ListAuthor = data;
    });
  }



  logout() {
    this.authService.logOut();
  }
  onWishlist(){
    this.router.navigate(['/wishlist']);
  }
  onCategory() {
    this.router.navigate(['/categorie']);
  }
   onAuteur() {
    this.router.navigate(['auteur']);
  }



}
