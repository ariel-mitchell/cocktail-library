package com.liftoff.cocktaillibrary.models.data;

import com.liftoff.cocktaillibrary.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
