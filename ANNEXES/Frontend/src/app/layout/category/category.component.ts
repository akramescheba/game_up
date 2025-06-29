import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { GameList, Category } from '../../models/models';
import { CategoriesService } from '../../services/categories.service';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss',
})
export class CategoryComponent implements OnInit {
  constructor(
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private categoryService: CategoriesService,
    private appService: AppService
  ) {}
  categoryForm!: FormGroup;
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

  reload() {
    location.reload();
  }

  ngOnInit() {
    this.getAllCategories();
    this.categoryForm = this.formBuilder.group({
      type: ['', Validators.required],
    });
  }

  getAllCategories() {
    this.categoryService.getAllCategories().subscribe((categories) => {
      this.listCategory = categories;
    });
  }
  postCategory() {
    this.categoryService
      .postCategory(this.categoryForm.value)
      .subscribe((category) => {
        this.toastr.success('Catégorie créee avec succès');

        this.categoryForm.reset();
        this.appService.reload();
      });
  }

  updatePartialCategory(): void {
    if (this.selectedCategory) {
      const categoryId = this.selectedCategory.id;
      const data = { ...this.selectedCategory };
      this.categoryService
        .updateCategory(categoryId, data)
        .subscribe((category) => {
          this.toastr.success('Catégorie modifiée avec succès');
          this.appService.reload();
        });
    } else {
      this.toastr.error('Erreur lors de la modification de la catégorie');
    }
  }
  deleteCategoryById(): void {
    if (this.selectedCategory) {
      const categoryId = this.selectedCategory.id;
      this.categoryService.deleteCategory(categoryId).subscribe(() => {
        this.toastr.success('Catégorie supprimée avec succès');
        this.appService.reload();
      });
    }
  }
}
