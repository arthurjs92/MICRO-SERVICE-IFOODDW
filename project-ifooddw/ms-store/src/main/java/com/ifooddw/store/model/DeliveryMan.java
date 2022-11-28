package com.ifooddw.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMan {

    private String id;
    private String name;
    private String cpf;
    private String licensePlate;
    private Store store;
    private List<Order> orders = new ArrayList<>();

}
