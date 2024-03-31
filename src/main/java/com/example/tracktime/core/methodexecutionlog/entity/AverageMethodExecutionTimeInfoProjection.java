package com.example.tracktime.core.methodexecutionlog.entity;

public interface AverageMethodExecutionTimeInfoProjection {

    String getClazzName();

    String getMethodName();

    Long getCount();

    Long getTotalExecutionTime();

}