package com.example.tracktime.core.methodexecutionlog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracktime.core.methodexecutionlog.web.dto.AverageMethodExecutionTimeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.CountByExecutionTypeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.TotalClazzMethodsExecutionTimeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.facade.MethodExecutionLogWebFacade;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "MethodExecutionLogController", description = "Сервис статистики времени выполнения методов")
@RestController
@RequestMapping(value = "method-execution-log-statistic")
@RequiredArgsConstructor
public class MethodExecutionLogController {

    private final MethodExecutionLogWebFacade webFacade;

    @Operation(summary = "Кол-во залогированных методов по типу")
    @GetMapping(value = "count-by-execution-type")
    public CountByExecutionTypeStatisticDto getCountByExecutionType() {
        return webFacade.getCountByExecutionType();
    }

    @Operation(summary = "Среднее время выполнения методов")
    @GetMapping(value = "average-method-execution-time")
    public AverageMethodExecutionTimeStatisticDto getAverageMethodExecutionTimeStatistic() {
        return webFacade.getAverageMethodExecutionTimeStatistic();
    }

    @Operation(summary = "Общее время выполнения методов для классов")
    @GetMapping(value = "total-clazz-methods-execution-time")
    public TotalClazzMethodsExecutionTimeStatisticDto getTotalClazzMethodsExecutionTimeStatistic() {
        return webFacade.getTotalClazzMethodsExecutionTimeStatistic();
    }

}
