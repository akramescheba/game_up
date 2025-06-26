import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { GameList, Category, Author } from '../../../models/models';
import { AppService } from '../../../services/app.service';
import { AuthorService } from '../../../services/author.service';
import { AuthService } from '../../../services/auth.service';
import { WishlistService } from '../../../services/wishlist.service';
import { CategoriesService } from '../../../services/categories.service';

@Component({
  selector: 'app-gamecrud',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule],
  templateUrl: './gamecrud.component.html',
  styleUrl: './gamecrud.component.scss',
})
export class GamecrudComponent implements OnInit {
  gameForm!: FormGroup;

  gameList: GameList[] = [];
  listCategory: Category[] = [];
  listAuthor: Author[] = [];

  selectedGame: GameList | null = null;
  selectedCategoryId: number | null = null;
  selectAuthorId: number | null = null;
  searchWord: string = '';
  isDisplayDetailCard: boolean = false;
  isDisplayEdit: boolean = false;

  constructor(
    private authService: AuthService,
    private appService: AppService,
    private authorService: AuthorService,
    private wishListService: WishlistService,
    private categoriesService: CategoriesService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.getGameList();

    this.gameForm = this.formBuilder.group({
      nom: ['', Validators.required],
      image: ['', Validators.required],
      authorId: [null, Validators.required],
      genre: ['', Validators.required],
      numEdition: ['', Validators.required],
      description: ['', Validators.required],
      categoryId: [null, Validators.required],
    });
    this.authorService.getAuthor().subscribe((author) => {
      this.listAuthor = author;
      console.log(author);
    });

    this.categoriesService.getAllCategories().subscribe((category) => {
      this.listCategory = category;
    });
  }
  displayEditForm() {
    this.isDisplayEdit = !this.isDisplayEdit;
  }
  selectGame(game: GameList): void {
    this.selectedGame = { ...game };
    this.isDisplayDetailCard = true;
  }
  selectedAuthorId(authorId: Author): void {
    this.selectAuthorId = authorId.id;
  }
  ajoutWishList(games: any): void {
    this.wishListService.ajoutWishList(games);
  }
  
    reload() {
    location.reload();
  }
/*FONCTION SEARCH*/
  getFilteredGames(): GameList[] {
    if (!this.searchWord) return this.gameList;
    const word = this.searchWord.toLowerCase();
    return this.gameList.filter((game) =>
      game.nom.toLowerCase().includes(word)
    );
  }
/*FONCTION GET*/
  getGameList(): void {
    this.appService.getAllGame().subscribe(
      (game) => {
        this.gameList = game;
        this.toastr.success('Jeux chargés avec succès');
      },
      (error) => {
        this.toastr.error('Erreur du chargement des jeux.');
      }
    );
  }

  /**FONCTION POST DE CREATION DE JEU */
  postGame() {
    if (this.gameForm.invalid) {
      this.toastr.warning('Veuillez remplir tous les champs correctement.');
      return;
    }
    const gameNom = this.gameForm.value.nom;
    this.appService.postGame(this.gameForm.value).subscribe(() => {
      this.toastr.success('Jeu créé avec succès', `${gameNom}`);
      console.log(this.gameForm.value);
    });
  }
  /*FONCTION PATCH POUR LA MISE A JOUR  DE JEU */
  updatePartialGame(): void {
    if (!this.selectedGame) {
      this.toastr.error('Aucun jeu sélectionné');
      return;
    }

    const gameId = this.selectedGame.id;
    const gameNom = this.selectedGame.nom;
    const patchData = {
      nom: this.selectedGame.nom,
      image: this.selectedGame.image,
      genre: this.selectedGame.genre,
      description: this.selectedGame.description,
      numEdition: this.selectedGame.numEdition,
      categoryId: this.selectedCategoryId,
      authorId: this.selectedAuthorId,
    };
    this.appService.updatePartialGame(gameId, patchData).subscribe((data) => {
      this.toastr.success(`Mise à jour du reussite`, `${gameNom} `);
      this.getGameList();
    });
  }

  /*FONCTION SUPPRESSION  DE JEU */
  deleteGameById(): void {
    if (this.selectedGame) {
      const gameId = this.selectedGame.id;
      this.appService.deleteGame(gameId).subscribe((data) => {
        this.toastr.success('Le jeu a été supprimé avec succès');
        location.reload();
      });
    }
  }

  /*BOUTON DE FERMETURE D'AFFICHAGE */
  closeDetailCard(): void {
    this.isDisplayDetailCard = false;
    this.selectedGame = null;
  }
}
