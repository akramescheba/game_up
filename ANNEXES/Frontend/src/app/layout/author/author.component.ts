import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { AuthorService } from '../../services/author.service';
import { ToastrService } from 'ngx-toastr';
import { Author, GameList } from '../../models/models';

@Component({
  selector: 'app-author',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './author.component.html',
  styleUrl: './author.component.scss',
})
export class AuthorComponent implements OnInit {
  ListAuthor: Author[] = [];
  authorForm: FormGroup = new FormGroup({});
  selectedAuthor: Author | null = null;
  selectedGame: GameList|null=null;

  isDisplayWarning: boolean = false;
  isDisplayEditCard: boolean = false;
  isDisplayAuthorDetails: boolean = false;
   isDisplayEdit: boolean=false;
  isDisplayDetailCard: boolean=false;

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
    private formBuilder: FormBuilder,
    private authorService: AuthorService,
    private toastr:ToastrService
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
    this.getAuthor();
    this.authorForm = this.formBuilder.group({
      name: ['', Validators.required],
    });
  }
  /*METHODE DE GET D'UN AUTHOR */
  getAuthor() {
    this.authorService.getAuthor().subscribe((data) => {
      this.ListAuthor = data;
    });
  }

  /*METHODE POST DE CREATION D'UN AUTHOR */
  postAuthor() {
      if (this.authorForm.invalid) {
      this.toastr.warning('🫤Veuillez remplir tous les champs correctement');
      return;
    }
    this.authorService.postAuthor(this.authorForm.value).subscribe((data) => {
    });
  }
  /*METHODE PATCH DE MISE A JOUR D'UN AUTHOR */
  updateAuthor(): void {
     if (this.authorForm.invalid) {
      this.toastr.warning('🫤Veuillez remplir tous les champs correctement');
      return;
    }

    if (this.selectedAuthor) {
      const authorId = this.selectedAuthor.id;
      const data = { ...this.selectedAuthor };
      this.authorService.updateAuthor(authorId, data).subscribe((author) => {

      });
    }
  }
  /*METHODE DELETE DE SUPPRESSION D'UN AUTHOR */
  deleteAuthorById(id: number) {
    this.authorService.deleteAuthorById(1).subscribe((data) => {
    });
  }
}
