package com.liftoff.cocktaillibrary.models.data;

import com.liftoff.cocktaillibrary.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {}
