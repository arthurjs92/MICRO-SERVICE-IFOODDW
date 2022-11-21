package com.ifooddw.user.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private Date date;
    private Double totalPrice;
    private Integer quantity;
    private String status;
    private User user;
    private List<Product> ordersProductsList = new ArrayList<>();

}
