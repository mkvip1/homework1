package com.example.tracktime.core.methodexecutionlog.web.facade;

import com.example.tracktime.core.methodexecutionlog.web.dto.AverageMethodExecutionTimeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.CountByExecutionTypeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.TotalClazzMethodsExecutionTimeStatisticDto;

public interface MethodExecutionLogWebFacade {

    CountByExecutionTypeStatisticDto getCountByExecutionType();

    AverageMethodExecutionTimeStatisticDto getAverageMethodExecutionTimeStatistic();

    TotalClazzMethodsExecutionTimeStatisticDto getTotalClazzMethodsExecutionTimeStatistic();

}
