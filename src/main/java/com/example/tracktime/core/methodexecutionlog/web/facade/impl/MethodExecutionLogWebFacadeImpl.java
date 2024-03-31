package com.example.tracktime.core.methodexecutionlog.web.facade.impl;

import org.springframework.stereotype.Service;

import com.example.tracktime.core.methodexecutionlog.mapper.MethodExecutionLogMapper;
import com.example.tracktime.core.methodexecutionlog.service.MethodExecutionLogService;
import com.example.tracktime.core.methodexecutionlog.web.dto.AverageMethodExecutionTimeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.CountByExecutionTypeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.TotalClazzMethodsExecutionTimeStatisticDto;
import com.example.tracktime.core.methodexecutionlog.web.facade.MethodExecutionLogWebFacade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MethodExecutionLogWebFacadeImpl implements MethodExecutionLogWebFacade {

    private final MethodExecutionLogService methodExecutionLogService;

    @Override
    public CountByExecutionTypeStatisticDto getCountByExecutionType() {
        var projections = methodExecutionLogService.getCountByExecutionType();
        return new CountByExecutionTypeStatisticDto()
                .setCountByExecutionType(MethodExecutionLogMapper.INSTANCE.toCountByExecutionTypeDtoList(projections));
    }

    @Override
    public AverageMethodExecutionTimeStatisticDto getAverageMethodExecutionTimeStatistic() {
        var models = methodExecutionLogService.getAverageMethodExecutionTimeInfo();
        return new AverageMethodExecutionTimeStatisticDto()
                .setAverageMethodExecutionTime(MethodExecutionLogMapper.INSTANCE.toAverageMethodExecutionTimeDtoList(models));
    }

    @Override
    public TotalClazzMethodsExecutionTimeStatisticDto getTotalClazzMethodsExecutionTimeStatistic() {
        var projections = methodExecutionLogService.getTotalClazzMethodsExecutionTime();
        return new TotalClazzMethodsExecutionTimeStatisticDto()
                .setTotalClazzMethodsExecutionTime(MethodExecutionLogMapper.INSTANCE.toTotalClazzMethodsExecutionTimeDtoList(projections));
    }

}
