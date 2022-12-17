package com.liftoff.cocktaillibrary.models.data;

import com.liftoff.cocktaillibrary.models.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {
}
