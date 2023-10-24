package com.example.Shopping.controller;

import com.example.Shopping.entity.Product;
import com.example.Shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/createProducts")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Get all products
    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get product by ID
    @GetMapping("/getProducts/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getProducts/category/{categories}")
    public ResponseEntity<List<Product>> getProductsByCategories(@PathVariable List<String> categories) {
        List<Product> products = productService.getProductsByCategory(categories);
        return ResponseEntity.ok(products);
    }

}
