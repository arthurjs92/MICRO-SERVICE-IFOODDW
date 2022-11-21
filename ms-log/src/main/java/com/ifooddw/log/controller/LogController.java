package com.ifooddw.log.controller;

import com.ifooddw.log.model.Log;

import com.ifooddw.log.service.logimpl.LogImpl;
import com.ifooddw.log.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController implements LogImpl {

    @Autowired
    private LogServiceImpl logServiceImpl;

    @Override
    @PostMapping
    public Log createLog(Log log) {
        return logServiceImpl.createLog(log);
    }

    @Override
    @GetMapping("/{id}")
    public Log findLogById(@PathVariable String id) {
        return logServiceImpl.findLogById(id);
    }

    @Override
    @GetMapping
    public List<Log> findAllLogs() {
        return logServiceImpl.findAllLogs();
    }

    @Override
    public Log updateLog(Log log) {
        return logServiceImpl.updateLog(log);
    }

    @Override
    public void deleteOneLog(String id) {
        logServiceImpl.deleteOneLog(id);
    }
}
