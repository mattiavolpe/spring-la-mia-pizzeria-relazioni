package org.java.app.db.service;

import org.java.app.db.pojo.Ingredient;
import org.java.app.db.repo.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepo ingredientRepo;
	
	public void saveIngredient(Ingredient ingredient) {
		ingredientRepo.save(ingredient);
	}
}
