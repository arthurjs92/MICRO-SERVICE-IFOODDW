package com.ifooddw.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
public class Order {

    @Id
    private String id;
    private Date date;
    private Double totalPrice = 0.00;
    private String status;
    private User user;

    @DBRef
    private List<Product> products = new ArrayList<>();

    public void calcTotalPrice() {
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
    }

}
