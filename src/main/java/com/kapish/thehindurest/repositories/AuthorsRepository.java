package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Authors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuthorsRepository extends MongoRepository<Authors, String>{
    Authors findBy_id(ObjectId _id);

    @Query("{author:'?0'}")
    List<Authors> findBy_author(String author);
}
