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
    private categoryService: CategoriesService
  ) {}
  categoryForm!: FormGroup;
  displayCategoryDetails: boolean = false;
  listCategory: Category[] = [];
  selectedCategory: Category | null = null;
  isDisplayEditCard: boolean = false;
  isDisplayWarning: boolean = false;

  displayDetails() {
    this.displayCategoryDetails = !this.displayCategoryDetails;
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
        this.reload();
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
        });
    } else {
      this.toastr.error('Veuillez sélectionner une catégorie');
    }
  }
  deleteCategoryById(): void {
    if (this.selectedCategory) {
      const categoryId = this.selectedCategory.id;
      this.categoryService.deleteCategory(categoryId).subscribe(() => {
        this.toastr.success('Catégorie supprimée avec succès');
        this.reload();
      });
    }
  }
}
