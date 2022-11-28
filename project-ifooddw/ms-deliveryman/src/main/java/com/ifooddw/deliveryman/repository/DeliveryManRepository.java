package com.ifooddw.deliveryman.repository;

import com.ifooddw.deliveryman.model.DeliveryMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryManRepository extends MongoRepository<DeliveryMan, String> {

    @Query("{cpf:?0}")
    DeliveryMan findByCpf(String cpf);

}
