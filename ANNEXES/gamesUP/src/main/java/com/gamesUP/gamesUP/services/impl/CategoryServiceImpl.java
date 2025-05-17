package com.gamesUP.gamesUP.services.impl;

import com.gamesUP.gamesUP.dao.CategoryRepository;
import com.gamesUP.gamesUP.exception.ExceptionEntityDontExist;
import com.gamesUP.gamesUP.model.Category;
import com.gamesUP.gamesUP.services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> findAllCategories() {
    return (List<Category>) categoryRepository.findAll();
  }

  @Override
  public Category findCategoryById(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    if (category.isPresent()) {
      return category.get();
    }
    throw new ExceptionEntityDontExist();
  }

  @Override
  public Long createCategory(Category category) {
    return categoryRepository.save(category).getId();
  }

  @Override
  public void update(Long id, Category categories) {
    Category categoryExistante = categoryRepository.findById(id)
      .orElseThrow(() -> new ExceptionEntityDontExist());
    categoryExistante.setType(categories.getType());
    categoryRepository.save(categoryExistante);
  }

@Override
public void updatePartial(Category categoryExistante, Category newCategories) {
    if (newCategories.getType() != null) {
    	categoryExistante.setType(newCategories.getType());
      }
      categoryRepository.save(categoryExistante);
    }

@Override
public void delete(Long id) {
	categoryRepository.deleteById(id);
	
}

}
