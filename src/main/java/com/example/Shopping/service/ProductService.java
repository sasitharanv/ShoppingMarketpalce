package com.example.Shopping.service;

import com.example.Shopping.entity.Product;
import com.example.Shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }
    public List<Product> getProductsByCategory(List<String> categories) {
        // Retrieve products by categories
        List<Product> products = new ArrayList<>();
        for (String category : categories) {
            List<Product> productsByCategory = productRepository.findByCategory(category);
            products.addAll(productsByCategory);
        }
        return products;
    }


    public List<Product> getProductsByCategoryAndSort(String category, String sortBy) {
        List<Product> products;
        if ("asc".equalsIgnoreCase(sortBy)) {
            // Sort by price in ascending order
            products = productRepository.findByCategoryOrderByPriceAsc(category);
        } else if ("desc".equalsIgnoreCase(sortBy)) {
            // Sort by price in descending order
            products = productRepository.findByCategoryOrderByPriceDesc(category);
        } else {
            // Default: retrieve unsorted products
            products = productRepository.findByCategory(category);
        }
        return products;
    }

}
