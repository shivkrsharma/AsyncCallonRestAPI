package com.example.SpringRestCallaable.Controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@org.springframework.web.bind.annotation.RestController
@EnableAsync
public class RestController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestOperations restOperations;

    @Autowired
    MovieService movieService;

    @Autowired
     myCallable callable;

    @RequestMapping("/myApp")
    public String sayHi() throws InterruptedException {

        System.out.println("Start time "+(System.currentTimeMillis())/100);
      for(int i=0;i< 100; i++){
          //restTemplate.getForObject("https://api.printful.com/countries", String.class);

          CompletableFuture<MovieModel> page1 = movieService.lookForMovie("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
       /*   ResponseEntity<Object> respponseEntity=
                  restOperations.exchange("https://api.printful.com/countries", HttpMethod.GET,null,Object.class);
       */  // System.out.println("Respnsec entity=="+respponseEntity);
      }
        System.out.println("End time "+(System.currentTimeMillis())/100);
      return  "sucess";
    }

    @RequestMapping("/newApp")
    public String sayHi1() throws ExecutionException, InterruptedException {


        System.out.println("Start time "+(System.currentTimeMillis())/1000);
        for(int i=0;i<100; i++){

            //Future<String> future = executorService.submit(callable);
            CompletableFuture<Object> page1 = movieService.lookForMovienew("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
            //System.out.println("movie title=="+page1.get().getTitle());
            //futurelist.add(future);

        }
        /*for(Future<String> future1 : futurelist){
            String srt=future1.get();
        }*/

        //executorService.shutdown();
        System.out.println("End time "+(System.currentTimeMillis())/1000);

        return  "sucess";
    }


    @RequestMapping("/myAppTest")
    public String sayHiTest() throws InterruptedException {

        System.out.println("Start time "+(System.currentTimeMillis())/100);
        for(int i=0;i< 100; i++){
            //restTemplate.getForObject("https://api.printful.com/countries", String.class);
        String url = String.format("https://ghibliapi.herokuapp.com/films/%s", "58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        ResponseEntity<Object> respponseEntity=
                  restOperations.exchange(url, HttpMethod.GET,null,Object.class);
         // System.out.println("Respnsec entity=="+respponseEntity);
        }

        System.out.println("End time "+(System.currentTimeMillis())/100);

        return  "sucess";
    }


    @RequestMapping("/UserfromGitNoraml")
    public String getUserfromGitHub() throws InterruptedException {

        System.out.println("End time "+(System.currentTimeMillis())/100);
        for(int i=1;i< 100; i++){
            //restTemplate.getForObject("https://api.printful.com/countries", String.class);
            //String url = String.format("https://api.github.com/users/%s", i);
            String url = String.format("https://jsonplaceholder.typicode.com/todos/%s", i);
            System.out.println(url);
            ResponseEntity<Object> respponseEntity=
                    restOperations.exchange(url, HttpMethod.GET,null,Object.class);
            // System.out.println("Respnsec entity=="+respponseEntity);
        }

        System.out.println("End time "+(System.currentTimeMillis())/100);

        return  "sucess";
    }

    @RequestMapping("/UserfromGitNoramlSync")
    public String getUserfromGitHubSync() throws InterruptedException {

        System.out.println("End time "+(System.currentTimeMillis())/100);
        for(int i=0;i< 100; i++){

            CompletableFuture<Object> page1 = movieService.lookforUserfromGit(i);
        }

        System.out.println("End time "+(System.currentTimeMillis())/100);

        return  "sucess";
    }









    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }



}
