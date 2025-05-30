package com.gamesUP.gamesUP.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.services.impl.CategoryServiceImpl;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {
	  @Autowired
	  private CategoryServiceImpl categoryServiceImpl;
	  @Test
	  void shouldGetAllCategories() {
	    List<Category> category = categoryServiceImpl.findAllCategories();
	    assertEquals(1, category.size());
	  }
	//Test GeById
	    @Test
	    void shouldGetCategoryById() {
	    	Category category = categoryServiceImpl.findCategoryById((long) 1);
	  	  assertEquals("category", category.getType());
	    };
	    //Test Post
	    @Test
	    void shouldCreateCategory() {
	      Category newCategory = new Category();
	      newCategory.setType("category");
	      assertEquals("category", newCategory.getType());
	    }
	    //Test Patch
	    @Test
	    void shouldUpdatePartialCategory() {
	  	  Category categoryExistant = categoryServiceImpl.findCategoryById((long) 1);
	  	Category newCategory = new Category();
	  	  newCategory.setType("category");
	  	categoryServiceImpl.updatePartial(categoryExistant, newCategory);
	    }
	    //Test Update
	    @Test
	    void shouldUpdateCategory() {
	    	Category category= categoryServiceImpl.findCategoryById(1L);
	    	Category newCategory = new Category();
	    	newCategory.setType("category");
	    	categoryServiceImpl.update(1L, category);
	    }
	    //Test delete
	    @Test
	    void shouldDeleteCategory() {
	    	categoryServiceImpl.delete((long) 1);
	  	};
		
}
