package com.ifooddw.deliveryman.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("deliverymans")
public class DeliveryMan {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String licensePlate;
    @DBRef
    private Store store;

    @DBRef
    private List<Order> orders = new ArrayList<>();

}
