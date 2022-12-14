package com.ifooddw.log.service;

import com.ifooddw.log.model.Log;
import com.ifooddw.log.repository.LogRepository;
import com.ifooddw.log.service.logimpl.LogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogImpl {

    @Autowired
    LogRepository logRepository;

    @Override
    public Log createLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log findLogById(String id) {
        return logRepository.findById(id).get();
    }

    @Override
    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Log updateLog(Log log) {
        if (log.getId() != null && !log.getId().isEmpty()) {
            return logRepository.save(log);
        }
        return log;
    }

    @Override
    public void deleteOneLog(String id) {
        var log = logRepository.findById(id).get();
        if (log.getId() != null && !log.getId().isEmpty()) {
            logRepository.delete(log);
        }
    }

//    private void createCollectionIfNotExists(String collection, MongoOperations mongoTemplate) {
//        CollectionOptions options = CollectionOptions.empty().capped().size(1024).maxDocuments(50);
//        if (!mongoTemplate.collectionExists(collection)) {
//            mongoTemplate.createCollection(collection, options);
//        }
//    }

    public Log fingLogByAction(String action) {
        return logRepository.findLogByAction(action);
    }

    public Log findLogByDateOfRegistry(String date) {
        return logRepository.findLogByDateOfRegistry(date);
    }

    public Log findLogByUser(String name) {
        return logRepository.findLogByUser(name);
    }
}
