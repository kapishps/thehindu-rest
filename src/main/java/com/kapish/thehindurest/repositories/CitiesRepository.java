package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Cities;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CitiesRepository extends MongoRepository<Cities, String>{
    Cities findBy_id(ObjectId _id);

    @Query("{city:'?0'}")
    List<Cities> findBy_city(String city);

}
