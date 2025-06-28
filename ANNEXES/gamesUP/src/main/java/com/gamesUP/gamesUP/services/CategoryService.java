package com.gamesUP.gamesUP.services;

import java.util.List;
import com.gamesUP.gamesUP.model.Category;


public interface CategoryService {
	public List<Category> findAllCategories();

	public Category findCategoryById(Long id);

	public Long createCategory(Category category);

	public void update(Long id, Category categories);

	public void updatePartial(Category categoryExistante, Category newCategories);

	public void delete(Long id);


}
