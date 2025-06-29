import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router} from '@angular/router';
import {
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { AuthorService } from '../../../../services/author.service';
import { AppService } from '../../../../services/app.service';
import { ToastrService } from 'ngx-toastr';
import { Author, GameList } from '../../../../models/models';


@Component({
  selector: 'app-auteur',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './auteur.component.html',
  styleUrl: './auteur.component.scss'
})
export class AuteurComponent implements OnInit{
  ListAuthor: Author[] = [];
  selectedAuthor: Author | null = null;
  selectedGame: GameList | null = null;

  isDisplayWarning: boolean = false;
  isDisplayEditCard: boolean = false;
  isDisplayAuthorDetails: boolean = false;
  isDisplayEdit: boolean = false;
  isDisplayDetailCard: boolean = false;

  displayWarningForm(author: Author) {
    this.isDisplayWarning = true;
  }
  displayEditCard() {
    this.isDisplayEditCard = true;
  }
  displayAuthorDetails() {
    this.isDisplayAuthorDetails = true;
  }

  constructor(
    private authorService: AuthorService,
    private appService: AppService,
    private toastr: ToastrService
  ) {}

  /*METHODE D'ACCES PAR SELECTION D'UN AUTHOR VIA SON ID*/
  selectAuthorId(author: Author): void {
    this.selectedAuthor = { ...author };
  }
  selectGame(game: GameList): void {
    this.selectedGame = { ...game };
    this.isDisplayDetailCard = true;
  }
  ngOnInit() {
this.getAllAuthors();

  }
  /*METHODE DE GET D'UN AUTHOR */
  getAllAuthors() {
    this.authorService.getAllAuthors().subscribe((data) => {
      this.ListAuthor = data;
    });
  }

}
