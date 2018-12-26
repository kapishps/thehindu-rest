package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Articles;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesRepository extends MongoRepository<Articles, String> {
    Articles findBy_id(ObjectId _id);
}
