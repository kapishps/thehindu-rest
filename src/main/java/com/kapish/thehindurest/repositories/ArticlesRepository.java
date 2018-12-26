package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Articles;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArticlesRepository extends MongoRepository<Articles, String> {
    Articles findBy_id(ObjectId _id);

    @Query("{tags : { $all : ?0 }}")
    List<Articles> findBy_tags(List<String> tags);

    @Query("{categories : { $all : ?0 }}")
    List<Articles> findBy_categories(List<String> categories);

//    @Query(value="{date:'?0'}", fields="{ author : 1, date: 1 }")
//    List<Articles> findAuthorsBy_date(String date);
}
