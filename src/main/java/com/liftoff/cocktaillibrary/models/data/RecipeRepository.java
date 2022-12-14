package com.liftoff.cocktaillibrary.models.data;

import com.liftoff.cocktaillibrary.models.Recipe;
import com.liftoff.cocktaillibrary.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
@Repository
@Transactional

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {}
