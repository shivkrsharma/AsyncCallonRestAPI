package com.example.SpringRestCallaable.Controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import sun.awt.windows.WPrinterJob;

import java.io.PrintStream;
import java.time.Instant;
import java.util.*;
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
    MyCallable callable;

    @RequestMapping("/myApp")
    public String sayHi() throws InterruptedException {

        System.out.println("Start time " + (System.currentTimeMillis()) / 100);
        for (int i = 0; i < 100; i++) {
            //restTemplate.getForObject("https://api.printful.com/countries", String.class);

            CompletableFuture<MovieModel> page1 = movieService.lookForMovie("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
       /*   ResponseEntity<Object> respponseEntity=
                  restOperations.exchange("https://api.printful.com/countries", HttpMethod.GET,null,Object.class);
       */  // System.out.println("Respnsec entity=="+respponseEntity);
        }
        System.out.println("End time " + (System.currentTimeMillis()) / 100);
        return "sucess";
    }

    @RequestMapping("/newApp")
    public String sayHi1() throws ExecutionException, InterruptedException {


        System.out.println("Start time " + (System.currentTimeMillis()) / 1000);
        for (int i = 0; i < 100; i++) {

            //Future<String> future = executorService.submit(callable);
            CompletableFuture<Object> page1 = movieService.lookForMovienew("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
            //System.out.println("movie title=="+page1.get().getTitle());
            //futurelist.add(future);

        }
        /*for(Future<String> future1 : futurelist){
            String srt=future1.get();
        }*/

        //executorService.shutdown();
        System.out.println("End time " + (System.currentTimeMillis()) / 1000);

        return "sucess";
    }


    @RequestMapping("/myAppTest")
    public String sayHiTest() throws InterruptedException {

        System.out.println("Start time " + (System.currentTimeMillis()) / 100);
        for (int i = 0; i < 100; i++) {
            //restTemplate.getForObject("https://api.printful.com/countries", String.class);
            String url = String.format("https://ghibliapi.herokuapp.com/films/%s", "58611129-2dbc-4a81-a72f-77ddfc1b1b49");
            ResponseEntity<Object> respponseEntity =
                    restOperations.exchange(url, HttpMethod.GET, null, Object.class);
            // System.out.println("Respnsec entity=="+respponseEntity);
        }

        System.out.println("End time " + (System.currentTimeMillis()) / 100);

        return "sucess";
    }


    /*@RequestMapping("/UserfromGitNoraml")
    public String getUserfromGitHub() throws InterruptedException {

        System.out.println("End time " + (System.currentTimeMillis()) / 100);
        for (int i = 1; i < 100; i++) {
            //restTemplate.getForObject("https://api.printful.com/countries", String.class);
            //String url = String.format("https://api.github.com/users/%s", i);
            String url = String.format("https://jsonplaceholder.typicode.com/todos/%s", i);
            System.out.println(url);
            ResponseEntity<Object> respponseEntity =
                    restOperations.exchange(url, HttpMethod.GET, null, Object.class);
            // System.out.println("Respnsec entity=="+respponseEntity);
        }

        System.out.println("End time " + (System.currentTimeMillis()) / 100);

        return "sucess";
    }*/

    @RequestMapping("/UserfromGitNoramlSync")
    public String getUserfromGitHubSync() throws InterruptedException, ExecutionException {

        CompletableFuture<UserData> page1 = null;
        System.out.println("End time " + (System.currentTimeMillis()) / 100);
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        CompletableFuture<String> completableFutures = null; //List to hold all the completable futures

        List<CompletableFuture<String>> completedTasks = new ArrayList<>();

        //ExecutorService yourOwnExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //List<UserData> responses = new ArrayList<>();

        Map<Integer, Integer> map21 = new HashMap<>();
        //map21.put(0,0);
        map21.put(1,1);
        map21.put(2,2);
        map21.put(3,3);
        map21.put(4,4);
        map21.put(5,5);
        map21.put(6,6);
        map21.put(7,7);
        map21.put(8,8);
        map21.put(9,9);
        map21.put(10,10);
        map21.put(11,11);
        map21.put(12,12);
        map21.put(13,13);
        map21.put(14,14);
        map21.put(15,15);
        map21.put(16,16);
        map21.put(17,17);
        map21.put(18,18);
        map21.put(19,19);
        map21.put(20,20);
        map21.put(21,21);
        map21.put(22,22);
        map21.put(23,23);
        map21.put(24,24);
        map21.put(25,25);
        map21.put(26,26);
        map21.put(27,27);
        map21.put(28,28);
        map21.put(29,29);
        map21.put(30,30);
        map21.put(31,31);
        map21.put(32,32);
        map21.put(33,33);
        map21.put(34,34);
        map21.put(35,35);
        map21.put(36,36);
        map21.put(37,37);
        map21.put(38,38);
        map21.put(39,39);
        map21.put(40,40);
        map21.put(41,41);
        map21.put(42,42);
        map21.put(43,43);
        map21.put(44,44);
        map21.put(45,45);
        map21.put(46,46);
        map21.put(47,47);
        map21.put(48,48);
        map21.put(49,49);
        map21.put(50,50);
        map21.put(51,51);
        map21.put(52,52);
        map21.put(53,53);
        map21.put(54,54);
        map21.put(55,55);
        map21.put(56,56);
        map21.put(57,57);
        map21.put(58,58);
        map21.put(59,59);
        map21.put(60,60);
        map21.put(61,61);
        map21.put(62,62);
        map21.put(63,63);
        map21.put(64,64);
        map21.put(65,65);
        map21.put(66,66);
        map21.put(67,67);
        map21.put(68,68);
        map21.put(69,69);
        map21.put(70,70);
        map21.put(71,71);
        map21.put(72,72);
        map21.put(73,73);
        map21.put(74,74);
        map21.put(75,75);
        map21.put(76,76);
        map21.put(77,77);
        map21.put(78,78);
        map21.put(79,79);
        map21.put(80,80);
        map21.put(81,81);
        map21.put(82,82);
        map21.put(83,83);
        map21.put(84,84);
        map21.put(85,85);
        map21.put(86,86);
        map21.put(87,87);
        map21.put(88,88);
        map21.put(89,89);
        map21.put(90,90);
        map21.put(91,91);
        map21.put(92,92);
        map21.put(93,93);
        map21.put(94,94);
        map21.put(95,95);
        map21.put(96,96);
        map21.put(97,97);
        map21.put(98,98);
        map21.put(99,99);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (Map.Entry<Integer, Integer> entry : map21.entrySet()) {
            completableFutures = CompletableFuture
                    .supplyAsync(() -> {
                                try {
                                    return movieService.lookforUserfromGit(entry);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                    );
            //collect all async tasks
           // System.out.print("-11-main method-->>>"+completableFutures.get());
            completedTasks.add(completableFutures);
        }
        CompletableFuture.allOf(completedTasks.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> System.out.println("Ended doing things"))
                .get();

        for(CompletableFuture<String> test:completedTasks )
        {
            System.out.println("==Return value in Conroller==>>>"+test.get());
        }
        System.out.println("End time " + (System.currentTimeMillis()) / 100);

        return "sucess";
    }


   /* @RequestMapping("/UserfromGitNoramlSync1")
    public String getUserfromGitHubSync4() throws InterruptedException, ExecutionException {


        CompletableFuture<UserData> page1 = null;
        System.out.println("End time " + (System.currentTimeMillis()) / 100);
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
        Instant start = Instant.now();
        List<CompletableFuture<UserData>> pendingTasks = new ArrayList<>();
        List<CompletableFuture<UserData>> completedTasks = new ArrayList<>();
        CompletableFuture<UserData> task = null;

        CompletableFuture<ResponseEntity<UserData>> response;

        Map<Integer, Integer> map21 = new HashMap<>();
        map21.put(1, 1);
        map21.put(2, 2);
        map21.put(3, 3);
        map21.put(4, 4);

        List<CompletableFuture<String>> future = new ArrayList<>();


        System.out.println("Started doing things");
        List<CompletableFuture<ResponseEntity<UserData>>> futures = new ArrayList();

        CompletableFuture<String> completableFuture;
        for (Map.Entry<Integer, Integer> i : map21.entrySet()) {
            //response =CompletableFuture.completedFuture(movieService.lookforUserfromGit1(i.getKey()));

            completableFuture=
                    (CompletableFuture<String>) CompletableFuture.completedFuture(movieService.lookforUserfromGit1(i.getKey()));
            //System.out.println(completableFuture.get());
            future.add(completableFuture);

        }

        System.out.println(future);


        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> System.out.println("Ended doing things"))
        .get();

        System.out.println(future);


       *//* System.out.println(futures.get(0).isDone());

        ResponseEntity<UserData> data=futures.get(0).get();
        data.getBody();

   return "sucess";
}


*/


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
