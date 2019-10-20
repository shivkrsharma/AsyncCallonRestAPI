package com.example.SpringRestCallaable.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
@Component
public class MyCallable implements Callable<UserData> {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestOperations restOperations;




    @Override
    public UserData call() throws Exception {

        ResponseEntity<UserData> respponseEntity=
                restOperations.exchange("https://api.printful.com/countries", HttpMethod.GET,null,UserData.class);

     return  respponseEntity.getBody();
    }

}
