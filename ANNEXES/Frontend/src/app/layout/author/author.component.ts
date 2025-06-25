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
import { Author } from '../../models/models';

@Component({
  selector: 'app-author',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule, CommonModule],
  templateUrl: './author.component.html',
  styleUrl: './author.component.scss',
})
export class AuthorComponent implements OnInit {
  ListAuthor: Author[] = [];
  authorForm: FormGroup = new FormGroup({});
  selectedAuthor: Author | null = null;

  isDisplayWarning: boolean = false;
  isDisplayEditCard: boolean = false;
  isDisplayAuthorDetails: boolean = false;


  displayWarningForm() {
    this.isDisplayWarning = true;
  }
  displayEditCard(){
    this.isDisplayEditCard = true;
  }
  displayAuthorDetails() {
    this.isDisplayAuthorDetails = true;
  }

  constructor(
    private formBuilder: FormBuilder,
    private authorService: AuthorService
  ) {}

  /*METHODE D'ACCES PAR SELECTION D'UN AUTHOR VIA SON ID*/
  selectAuthorId(author: Author): void {
    this.selectedAuthor = {...author};
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
    this.authorService.postAuthor(this.authorForm.value).subscribe((data) => {
      console.log(data);
    });
  }
    /*METHODE PATCH DE MISE A JOUR D'UN AUTHOR */
  updateAuthor(): void{
    if(this.selectedAuthor){
      const authorId = this.selectedAuthor.id;
      const data = {...this.selectedAuthor}
          this.authorService.updateAuthor(authorId,data).subscribe((author)=>{
      console.log(data);
    })
    }
  }
    /*METHODE DELETE DE SUPPRESSION D'UN AUTHOR */
  deleteAuthorById(id: number) {
    this.authorService.deleteAuthorById(1).subscribe((data) => {
      console.log(data);
    });
  }
}
