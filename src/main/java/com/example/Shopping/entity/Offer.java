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
@Document(collection = "offers")
public class Offer {
    @Id
    private String id;
    private String productId;  // Id of the product being offered on
    private String userId;     // Id of the user making the offer
    private double amount;

}
