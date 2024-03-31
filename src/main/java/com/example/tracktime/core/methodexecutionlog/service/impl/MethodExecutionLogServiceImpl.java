package com.example.tracktime.core.methodexecutionlog.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;
import com.example.tracktime.core.methodexecutionlog.repository.MethodExecutionLogRepository;
import com.example.tracktime.core.methodexecutionlog.service.MethodExecutionLogService;
import com.example.tracktime.core.methodexecutionlog.service.mapper.MethodExecutionLogMapper;
import com.example.tracktime.core.methodexecutionlog.service.validator.MethodExecutionLogValidator;

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

}
