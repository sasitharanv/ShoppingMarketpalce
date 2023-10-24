package com.example.Shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "wishlists")
public class Whishlist {
    @Id
    private String id;
    private String productId;  // Id of the product in the wishlist
    private String userId;     // Id of the user who added the product to their wishlist

}