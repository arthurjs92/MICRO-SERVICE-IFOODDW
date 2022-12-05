package com.ifooddw.log.repository;

import com.ifooddw.log.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

    @Query("{action: ?0}")
    Log findLogByAction(String action);
    @Query("{date:?0}")
    Log findLogByDateOfRegistry(String date);
    @Query("{object.name: ?0}")
    Log findLogByUser(String userName);

}
