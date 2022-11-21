package com.ifooddw.log.service.logimpl;

import com.ifooddw.log.model.Log;

import java.util.List;

public interface LogImpl {

    Log createLog(Log log);
    Log findLogById(String id);
    List<Log> findAllLogs();
    Log updateLog(Log log);
    void deleteOneLog(String id);

}
