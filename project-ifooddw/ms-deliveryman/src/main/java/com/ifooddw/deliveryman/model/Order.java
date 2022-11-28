package com.ifooddw.deliveryman.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private Date date;
    private Double totalPrice = 0.00;
    private String status;
    private List<Product> products = new ArrayList<>();

}
