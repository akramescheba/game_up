package com.gamesUP.gamesUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.services.CategoryService;


@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> findAllCategories() {
		return categoryService.findAllCategories();	
	};
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable("id") Long id) {
		Category category = categoryService.findCategoryById(id);
		
		if(category==null) {
			
		}return category;
		
	}
	
	@PostMapping("/category")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Long createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
		
	};
	

}
