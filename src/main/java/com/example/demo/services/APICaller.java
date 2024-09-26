package com.example.demo.services;

import com.example.demo.dataTypes.User;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class APICaller {


    private final RestClient client;

    public APICaller (RestClient.Builder builder){
        this.client = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
    }


    public User getUser(String id){
        return client.get().uri("/users/{id}", id).retrieve().body(User.class);
    }
}
