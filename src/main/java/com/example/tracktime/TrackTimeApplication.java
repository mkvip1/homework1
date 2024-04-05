package com.example.tracktime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.tracktime.examples.ExampleService;

@EnableAsync
@SpringBootApplication
public class TrackTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackTimeApplication.class, args);
    }

    @Autowired
    private ExampleService exampleService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        exampleService.doItSync();
        exampleService.doItAsync();
    }

}
