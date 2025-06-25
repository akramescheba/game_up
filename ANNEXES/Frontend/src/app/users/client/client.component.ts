import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {GameList} from '../../models/models';
import { AuthService } from '../../services/auth.service';
import { AppService } from '../../services/app.service';
import { AvisService } from '../../services/avis.service';
import { WishlistService } from '../../services/wishlist.service';
import { CategoriesService } from '../../services/categories.service';
import { FooterComponent } from '../../header/footer/footer.component';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './client.component.html',
  styleUrl: './client.component.scss',
})
export class ClientComponent implements OnInit {
  constructor(
    private authService: AuthService,
    private appService: AppService,
    private avisService: AvisService,
    private categoriesService: CategoriesService,
    private wishlistService: WishlistService
  ) {}

  gameList: any[] = [];
  wishList: GameList[] = [];
  avisList: any[] = [];
  categoryList: any[] = [];

  searchWord: string = '';
  selectedGame: GameList | null = null;
  isDisplayDetailCard: boolean = false;
  isDisplayEdit: boolean = false;
  
  isWishlistExistant(): boolean {
  return !!this.selectedGame && this.wishList.some(g => g.id === this.selectedGame!.id);
}

  @Input() wishlist!: GameList;
  selectGame(game: GameList): void {
    this.selectedGame = { ...game };
    this.isDisplayDetailCard = true;
  }
/*FONCTION SEARCH*/
  getFilteredGames(): GameList[] {
    if (!this.searchWord) return this.gameList;
    const word = this.searchWord.toLowerCase();
    return this.gameList.filter((game) =>
      game.nom.toLowerCase().includes(word)
    );
  }

  ngOnInit() {
    this.getAllGames();
    this.getAllCategories();
    this.getAllAvis();
  }
/*FONCTION GET D'AFFICHAGE DES JEUX*/
  getAllGames(): void {
    this.appService.getAllGame().subscribe((games) => {
      this.gameList = games;
    });
  }
/*FONCTION GET D'AFFICHAGE DES CATEGORIES*/
  getAllCategories(): void {
    this.categoriesService.getAllCategories().subscribe((categories) => {
      this.categoryList = categories;
    });
  }
/*FONCTION GET D'AFFICHAGE DES AVIS*/
  getAllAvis(): void {
    this.avisService.getAvis().subscribe((avis) => {
      this.avisList = avis;
    });
  }
/*METHODE LOGOUT*/
  logout() {
    this.authService.logOut();
  }
}
