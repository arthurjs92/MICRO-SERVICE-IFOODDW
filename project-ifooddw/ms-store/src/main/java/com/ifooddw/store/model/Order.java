package com.ifooddw.store.model;

import com.ifooddw.store.dto.OrderDTO;
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
    private Date date = new Date();
    private Double totalPrice;
    private String status;
    private String address;

    @DBRef
    private List<Product> products = new ArrayList<>();

    public void calcTotalPrice() {
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
    }

    public Order(OrderDTO orderDTO) {
        this.products = orderDTO.getProducts();
    }

}
