package com.example.tracktime.core.methodexecutionlog.service;

import java.util.List;

import com.example.tracktime.core.methodexecutionlog.entity.CountByExecutionTypeProjection;
import com.example.tracktime.core.methodexecutionlog.entity.TotalClazzMethodsExecutionTimeProjection;
import com.example.tracktime.core.methodexecutionlog.model.AverageMethodExecutionTime;
import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;

public interface MethodExecutionLogService {

    void create(MethodExecutionLogCreateParam param);

    List<CountByExecutionTypeProjection> getCountByExecutionType();

    List<AverageMethodExecutionTime> getAverageMethodExecutionTimeInfo();

    List<TotalClazzMethodsExecutionTimeProjection> getTotalClazzMethodsExecutionTime();

}