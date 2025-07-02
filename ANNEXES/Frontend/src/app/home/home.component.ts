import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {
  FormBuilder,
  FormsModule,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { GameList, Category } from '../models/models';
import { ToastrService } from 'ngx-toastr';
import { AppService } from '../services/app.service';
import {FooterComponent} from '../header/footer/footer.component'

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  gameList: GameList[] = [];
  listCategory: Category[] = [];
  gameForm!: FormGroup;
  selectedGame: GameList | null = null;
  selectedCategoryId: number | null = null;
  searchWord: string = '';
  isDisplayDetailCard: boolean = false;
  isDisplayEdit: boolean = false;

  constructor(
    private route : Router,
    private appService: AppService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {}
authentification(){
  this.route.navigate(['/auth'])
}
  ngOnInit() {
    this.getGameList();
    this.gameForm = this.formBuilder.group({
      nom: ['', Validators.required],
      image: ['', Validators.required],
      author: ['', Validators.required],
      genre: ['', Validators.required],
      numEdition: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  reload() {
    location.reload();
  }
  selectGame(game: GameList): void {
    this.selectedGame = { ...game };
    this.isDisplayDetailCard = true;
  }

  /*FONCTION DE RECHERCHE DE JEU */
  getFilteredGames(): GameList[] {
    if (!this.searchWord) return this.gameList;
    const word = this.searchWord.toLowerCase();
    return this.gameList.filter((game) =>
      game.nom.toLowerCase().includes(word)
    );
  }
  /*FONCTION DE RECUPERATION DE JEU DANS LA BD*/
  getGameList(): void {
    this.appService.getAllGame().subscribe(
      (game) => {
        this.gameList = game;
        this.toastr.success('Jeux chargés avec succès');
      },
      (error) => {
        this.toastr.error('Impossible de charger les jeux.');
      }
    );
  }
  /*FONCTION DE CREATION DE JEU */
  postGame() {
    this.appService.postGame(this.gameForm.value).subscribe(
      (game) => {
        this.toastr.success('Jeux créé avec succès');
        this.getGameList();
        this.gameForm.reset();
      },
      (error) => {
        this.toastr.error('Impossible de créer le jeu.');
      }
    );
  }
   /*FONCTION DE MODIFICATION DE JEU */
  updatePartialGame(): void {
    if (this.selectedGame) {
      const gameId = this.selectedGame.id;
      const patchDate = { ...this.selectedGame };
      this.appService.updatePartialGame(gameId, patchDate).subscribe((data) => {
        this.toastr.success('Le jeu a été modifié avec succès');
      });
    }
  }
  /*FONCTION DE SUPPRESSION DE JEU */
  deleteGameById(): void {
    if (this.selectedGame) {
      const gameId = this.selectedGame.id;
      this.appService.deleteGame(gameId).subscribe((data) => {
        this.toastr.success('Le jeu a été supprimé avec succès');
      });
    }
  }

    /*BOUTON DE FERMETURE D'AFFICHAGE DE JEU */
  closeDetailCard(): void {
    this.isDisplayDetailCard = false;
    this.selectedGame = null;
  }
}
