import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { GameList, Category } from '../../../../models/models';
import { CategoriesService } from '../../../../services/categories.service';
import { AppService } from '../../../../services/app.service';

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.scss'
})
export class CategoriesComponent implements OnInit{
 constructor(
    private toastr: ToastrService,
    private categoryService: CategoriesService,
    private appService: AppService
  ) {}

  listCategory: Category[] = [];
  selectedCategory: Category | null = null;
  selectedGame: GameList | null = null;
  isDisplayCategoryDetails: boolean = false;
  isDisplayWarning: boolean = false;
  isDisplayEditCard: boolean = false;
  isDisplayBtn: boolean = false;
  isDisplayEdit: boolean = false;
  isDisplayDetailCard: boolean = false;

  selectGame(game: GameList): void {
    this.selectedGame = { ...game };
    this.isDisplayDetailCard = true;
  }
  displayDeleteCategorie(category: Category) {
    this.isDisplayBtn = true;
  }
  displayDetails() {
    this.isDisplayCategoryDetails = !this.isDisplayCategoryDetails;
  }
  displayEditCard(category: Category) {
    this.isDisplayEditCard = !this.isDisplayEditCard;
  }
  displayWarningForm() {
    this.isDisplayWarning = !this.isDisplayWarning;
  }
  selectCategory(category: Category): void {
    this.selectedCategory = { ...category };
  }

    ngOnInit() {
    this.getAllCategories();
  }

    getAllCategories() {
    this.categoryService.getAllCategories().subscribe((categories) => {
      this.listCategory = categories;
    });
  }

}
