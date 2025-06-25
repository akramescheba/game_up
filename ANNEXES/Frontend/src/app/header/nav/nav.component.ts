import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import  {GameList} from '../../models/models'; 
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

  constructor(private router: Router, private authService: AuthService) {}

  gameList: GameList[]=[];
  searchKeyWord: string = '';

  searchGames(): GameList[]{
    if(!this.searchKeyWord) return this.gameList;
    const keyWord = this.searchKeyWord.toLowerCase();
    return this.gameList.filter((game)=>{
      game.nom.toLowerCase().includes(keyWord)
    })

  }
  logout() {
    this.authService.logOut();
  }
  onWishlist(){
    this.router.navigate(['/wishlist']);
    console.log('wishlist est cliqué')
  }
  onCategory() {
    this.router.navigate(['/category']);
  }
}
