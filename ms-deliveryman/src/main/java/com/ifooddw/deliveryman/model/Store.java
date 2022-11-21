package com.ifooddw.deliveryman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private String id;
    private String name;
    private String cnpj;
    private DeliveryMan deliveryMan;
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

}
