package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Articles;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArticlesRepository extends MongoRepository<Articles, String> {
    Articles findBy_id(ObjectId _id);

    @Query("{author:'?0'}")
    List<Articles> findBy_author(String author);

    @Query("{date:'?0'}")
    List<Articles> findBy_date(String date);

    @Query("{city:'?0'}")
    List<Articles> findBy_city(String city);
}
