package com.ifooddw.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private Double price;

    private List<Order> ordersProducts = new ArrayList<>();

    private List<Store> storeList = new ArrayList<>();

}
