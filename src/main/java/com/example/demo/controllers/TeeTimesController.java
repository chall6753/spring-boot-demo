package com.example.demo.controllers;

import com.example.demo.WelcomeMessage;
import com.example.demo.dataTypes.User;
import com.example.demo.services.APICaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeeTimesController {
    Logger log = LoggerFactory.getLogger(WelcomeMessage.class);
    ObjectMapper mapper = new ObjectMapper();
    private APICaller client;

    public TeeTimesController(APICaller client) {
        this.client = client;
    }

    @GetMapping(value = "/users/{id}")
    public String getUsers(@PathVariable final String id) throws JsonProcessingException {
        User user = client.getUser(id);
        log.info("asdasdasd");
        return mapper.writeValueAsString(user);
    }

}
