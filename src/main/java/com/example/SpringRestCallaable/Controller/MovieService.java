package com.example.SpringRestCallaable.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final RestTemplate restTemplate;
    @Autowired
    RestOperations restOperations;

    public MovieService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }



    @Async("threadPoolTaskExecutor")
    public CompletableFuture<MovieModel> lookForMovie(String movieId) throws InterruptedException {
        LOG.info("Looking up Movie ID: {}", movieId);
        String url = String.format("https://ghibliapi.herokuapp.com/films/%s", movieId);
        System.out.println(url);
        MovieModel results = restTemplate.getForObject(url, MovieModel.class);
        // Artificial delay of 1s for demonstration purposes
        //Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Object> lookForMovienew(String movieId) throws InterruptedException {
        LOG.info("Looking up Movie ID: {}", movieId);

        String url = String.format("https://ghibliapi.herokuapp.com/films/%s", "58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        ResponseEntity<Object> results=
                restOperations.exchange(url, HttpMethod.GET,null,Object.class);

        //MovieModel results = restTemplate.getForObject(url, MovieModel.class);
        // Artificial delay of 1s for demonstration purposes
        //Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Async("threadPoolTaskExecutor")
    p ublic CompletableFuture<Object> lookforUserfromGit(int s) {


        ///String url = String.format("https://api.github.com/users/%s", s);
        String url = String.format("https://jsonplaceholder.typicode.com/todos/%s", s);
        System.out.println(url);
        ResponseEntity<Object> respponseEntity=
                restOperations.exchange(url, HttpMethod.GET,null,Object.class);
        //respponseEntity.getBody()
        return CompletableFuture.completedFuture(respponseEntity.getBody());
    }
}
