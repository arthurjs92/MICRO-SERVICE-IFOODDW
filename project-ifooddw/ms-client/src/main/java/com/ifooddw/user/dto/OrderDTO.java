package com.ifooddw.user.dto;

import com.ifooddw.user.model.Product;
import com.ifooddw.user.model.User;
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
    private List<Product> products = new ArrayList<>();

}
