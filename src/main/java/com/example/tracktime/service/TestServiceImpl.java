package com.example.tracktime.service;

import org.springframework.stereotype.Service;

import com.example.tracktime.core.annotation.TrackTime;

@Service
public class TestServiceImpl implements TestService {

    @Override
    @TrackTime
    public void doItSync() {
        System.out.println(Thread.currentThread().getName());
    }
}