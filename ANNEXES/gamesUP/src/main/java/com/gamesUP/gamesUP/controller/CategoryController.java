package com.gamesUP.gamesUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.services.CategoryService;



@RestController
@JsonIgnoreProperties("category")
@CrossOrigin(origins={"http://localhost:4200"},  allowedHeaders = "*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")

	public List<Category> getAllCategories() {
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
		
	}
	
	@PutMapping("/category/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Category categories){
		  if (categoryService.findCategoryById(id) == null) {
		      throw new ExceptionEntityDontExist();
		    }
		  categoryService.update(id, categories);
		  }
	
	@PatchMapping("category/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void updatePartialCategory(@PathVariable Long id, @RequestBody Category newCategories) {
		Category categoryExistante = categoryService.findCategoryById(id);

	    if (categoryExistante == null) {
	      throw new ExceptionEntityDontExist();
	    }
	    categoryService.updatePartial(categoryExistante, newCategories);
	  }
	
	@DeleteMapping("category/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteCategory(@PathVariable Long id) {
		  if (categoryService.findCategoryById(id) == null) {
		      throw new ExceptionEntityDontExist();
		    }
		  categoryService.delete(id);
		
	}
		
	}
		

	

