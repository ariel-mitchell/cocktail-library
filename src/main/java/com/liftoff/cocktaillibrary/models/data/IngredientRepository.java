package com.liftoff.cocktaillibrary.models.data;

import com.liftoff.cocktaillibrary.models.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


}
