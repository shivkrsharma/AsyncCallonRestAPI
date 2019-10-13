package com.example.SpringRestCallaable.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
@Component
public class myCallable implements Callable<String> {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestOperations restOperations;

    @Override
    public String call() throws Exception {

        ResponseEntity<Object> respponseEntity=
                restOperations.exchange("https://api.printful.com/countries", HttpMethod.GET,null,Object.class);

     return  "sucess";
    }

}
