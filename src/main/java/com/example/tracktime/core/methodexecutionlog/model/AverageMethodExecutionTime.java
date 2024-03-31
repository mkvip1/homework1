package com.example.tracktime.core.methodexecutionlog.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AverageMethodExecutionTime {
    private String clazzName;
    private String methodName;
    private BigDecimal averageExecutionTime;
}