package com.example.Shopping.repository;

import com.example.Shopping.entity.Whishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WhishlistRepository extends MongoRepository<Whishlist,String> {

}
