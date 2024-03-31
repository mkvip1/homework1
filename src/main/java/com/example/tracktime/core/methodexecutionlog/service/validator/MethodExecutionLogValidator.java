package com.example.tracktime.core.methodexecutionlog.service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.example.tracktime.core.methodexecutionlog.dto.MethodExecutionLogCreateParam;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MethodExecutionLogValidator {

    private final Validator validator;

    public void validateCreateParam(MethodExecutionLogCreateParam param) {
        validator.validateObject(param);
        if (!param.isSuccessful() && param.getExecutionTime() > 0) {
            throw new IllegalStateException("Duration cannot be greater than 0, when successful is false");
        }
    }

}
