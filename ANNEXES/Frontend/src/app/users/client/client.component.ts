import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { FormsModule, FormGroup,ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import {GameList, Recommendations } from '../../models/models';
import { AuthService } from '../../services/auth.service';
import { AppService } from '../../services/app.service';
import { AvisService } from '../../services/avis.service';
import { WishlistService } from '../../services/wishlist.service';
import { CategoriesService } from '../../services/categories.service';
import {RecommendationsService} from '../../services/recommendations.service';
import {AvisComponent} from '../../modal/avis/avis.component';
import { FooterComponent } from '../../header/footer/footer.component';
import {ToastrService} from 'ngx-toastr'

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [RouterOutlet,CommonModule, ReactiveFormsModule, FormsModule, AvisComponent],
  templateUrl: './client.component.html',
  styleUrl: './client.component.scss',
})
export class ClientComponent implements OnInit {
  constructor(
    private authService: AuthService,
    private appService: AppService,
    private avisService: AvisService,
    private categoriesService: CategoriesService,
    private recommendationService :RecommendationsService,
    private wishlistService: WishlistService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private router: Router,
  ) { }
  gameList: any[] = [];
  wishList: GameList[] = [];
  avisList: any[] = [];
  categoryList: any[] = [];

  recommendationsList:Recommendations[]=[];
  userId!: ''
  searchWord: string = '';
  selectedGame: GameList | null = null;
  isDisplayDetailCard: boolean = false;
  isDisplayEdit: boolean = false;
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
    this.getRecommendation();
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

  /*APPEL DE L4API PYTHON DE RECOMMENDATIONS*/
   getRecommendation():void{
      const userId = 1
  if (!userId) {
    this.toastr.error("Utilisateur non connecté.", `${userId}`);
    return;
  }

    this.recommendationService.getRecommendation(userId).subscribe((recommendations) =>{
      this.recommendationsList = recommendations;
      console.log(userId)
      
    })
  }

/*METHODE LOGOUT*/
  logout() {
    this.authService.logOut();
  }
}
