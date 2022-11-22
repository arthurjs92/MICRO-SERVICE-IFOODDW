package com.ifooddw.log.controller;

import com.ifooddw.log.model.Log;

import com.ifooddw.log.service.LogServiceImpl;
import com.ifooddw.log.service.logimpl.LogImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController implements LogImpl {

    @Autowired
    private LogServiceImpl logService;

    @Override
    @PostMapping
    public Log createLog(Log log) {
        return logService.createLog(log);
    }

    @Override
    @GetMapping("/{id}")
    public Log findLogById(@PathVariable String id) {
        return logService.findLogById(id);
    }

    @Override
    @GetMapping
    public List<Log> findAllLogs() {
        return logService.findAllLogs();
    }

    @Override
    public Log updateLog(Log log) {
        return logService.updateLog(log);
    }

    @Override
    public void deleteOneLog(String id) {
        logService.deleteOneLog(id);
    }
}
