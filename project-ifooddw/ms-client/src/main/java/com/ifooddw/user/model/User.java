package com.ifooddw.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("clients")
public class User {

    private String id;
    private String name;
    private String cpf;
    private List<String> address;
    @DBRef
    private List<Order> orders;

}
