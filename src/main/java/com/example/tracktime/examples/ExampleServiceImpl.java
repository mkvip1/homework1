package com.example.tracktime.examples;

import org.springframework.stereotype.Service;

import com.example.tracktime.core.tracktime.annotation.TrackAsyncTime;
import com.example.tracktime.core.tracktime.annotation.TrackTime;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    @TrackTime
    public void doItSync() {

    }

    @Override
    @TrackAsyncTime
    public void doItAsync() {

    }
}
