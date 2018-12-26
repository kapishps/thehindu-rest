package com.kapish.thehindurest.repositories;

import com.kapish.thehindurest.models.Dates;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DatesRepository extends MongoRepository<Dates, String>{
    Dates findBy_id(ObjectId _id);

    @Query("{date:'?0'}")
    List<Dates> findBy_date(String date);
}
