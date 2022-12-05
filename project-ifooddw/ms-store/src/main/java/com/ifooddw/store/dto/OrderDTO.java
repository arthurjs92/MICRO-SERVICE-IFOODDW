package com.ifooddw.store.dto;

import com.ifooddw.store.model.Product;
import com.ifooddw.store.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String idStore;
    private User user;
    private String address;
    private List<Product> products = new ArrayList<>();

}
