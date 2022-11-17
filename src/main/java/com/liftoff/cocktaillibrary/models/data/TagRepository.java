package com.liftoff.cocktaillibrary.models.data;


import com.liftoff.cocktaillibrary.models.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{
}

