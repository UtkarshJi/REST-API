package com.bfhl.api.controller;

import com.bfhl.api.model.RequestData;
import com.bfhl.api.model.ResponseData;
import com.bfhl.api.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping
    public ResponseEntity<ResponseData> processData(@RequestBody RequestData request) {
        ResponseData response = dataProcessingService.processData(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getOperationCode() {
        return ResponseEntity.ok(Map.of("operation_code", 1));
    }
}