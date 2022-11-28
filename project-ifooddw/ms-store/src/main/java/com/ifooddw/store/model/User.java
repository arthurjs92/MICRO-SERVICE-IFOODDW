package com.ifooddw.store.model;

import com.ifooddw.store.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String cpf;
    private List<String> address;
    private List<Order> orders;

    public User(UserDTO userDTO){
        this.name = userDTO.getName();
        this.cpf = userDTO.getCpf();
        this.address = userDTO.getAddress();
    }

}
