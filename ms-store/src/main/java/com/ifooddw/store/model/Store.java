package com.ifooddw.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("stores")
public class Store {

    @Id
    private String id;
    @NotBlank(message = "Field name can't be empty.")
    private String name;
    @NotBlank(message = "Field cnpj can't be empty.")
    private String cnpj;
    private DeliveryMan deliveryMan;

    @DBRef
    private List<Product> products = new ArrayList<>();

    @DBRef
    private List<Order> orders = new ArrayList<>();

}
