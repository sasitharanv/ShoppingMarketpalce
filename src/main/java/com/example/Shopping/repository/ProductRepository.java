package com.example.Shopping.repository;

import com.example.Shopping.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
    List<Product> findByCategoryOrderByPriceAsc(String category);
    List<Product> findByCategoryOrderByPriceDesc(String category);

}