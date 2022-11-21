package com.ifooddw.log.repository;

import com.ifooddw.log.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

    Log findLogByAction(String action);
    Log findLogByDateOfRegistry(String date);
    Log findLogByDateOfUpdate(String date);
    Log findLogByDateOfRemotion(String date);
    Log findLogByUser(String userName);
    Log findLogByStore(String storeName);

}
