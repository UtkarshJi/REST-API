package com.bfhl.api.service;

import com.bfhl.api.model.RequestData;
import com.bfhl.api.model.ResponseData;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    public ResponseData processData(RequestData request) {
        // Ensure request data is not null
        if (request.getData() == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        List<String> data = request.getData();

        // Filter numbers and alphabets
        List<String> numbers = data.stream()
                .filter(item -> item.matches("\\d+")) // Matches one or more digits
                .collect(Collectors.toList());

        List<String> alphabets = data.stream()
                .filter(item -> item.matches("[a-zA-Z]")) // Matches single alphabets
                .collect(Collectors.toList());

        // Find the highest alphabet (case-insensitive)
        String highestAlphabet = alphabets.stream()
                .max(Comparator.comparing(String::toLowerCase))
                .orElse(null);

        // Create and populate the response
        ResponseData response = new ResponseData();
        response.setIs_success(true);
        response.setUser_id("john_doe_17091999");
        response.setEmail("john@xyz.com");
        response.setRoll_number("ABCD123");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_alphabet(highestAlphabet != null ? List.of(highestAlphabet) : List.of());

        return response;
    }
}