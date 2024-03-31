package com.example.tracktime.core.methodexecutionlog.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tracktime.core.methodexecutionlog.entity.CountByExecutionTypeProjection;
import com.example.tracktime.core.methodexecutionlog.entity.TotalClazzMethodsExecutionTimeProjection;
import com.example.tracktime.core.methodexecutionlog.mapper.MethodExecutionLogMapper;
import com.example.tracktime.core.methodexecutionlog.model.AverageMethodExecutionTime;
import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;
import com.example.tracktime.core.methodexecutionlog.repository.MethodExecutionLogRepository;
import com.example.tracktime.core.methodexecutionlog.service.MethodExecutionLogService;
import com.example.tracktime.core.methodexecutionlog.validator.MethodExecutionLogValidator;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MethodExecutionLogServiceImpl implements MethodExecutionLogService {

    private final MethodExecutionLogRepository repository;
    private final MethodExecutionLogValidator methodExecutionLogValidator;

    @Async
    @Override
    @Transactional
    public void create(MethodExecutionLogCreateParam param) {
        methodExecutionLogValidator.validateCreateParam(param);
        var newEntity = MethodExecutionLogMapper.INSTANCE.toEntity(param);
        repository.save(newEntity);
    }

    @Override
    public List<CountByExecutionTypeProjection> getCountByExecutionType() {
        return repository.getCountByExecutionType();
    }

    @Override
    public List<AverageMethodExecutionTime> getAverageMethodExecutionTimeInfo() {
        var projections = repository.getAverageMethodExecutionTimeInfo();
        return projections.stream()
                .map(p -> AverageMethodExecutionTime.builder()
                        .clazzName(p.getClazzName())
                        .methodName(p.getMethodName())
                        .averageExecutionTime(new BigDecimal(p.getTotalExecutionTime())
                                .divide(new BigDecimal(p.getCount()), RoundingMode.HALF_UP))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TotalClazzMethodsExecutionTimeProjection> getTotalClazzMethodsExecutionTime() {
        return repository.getTotalClazzMethodsExecutionTime();
    }

}
