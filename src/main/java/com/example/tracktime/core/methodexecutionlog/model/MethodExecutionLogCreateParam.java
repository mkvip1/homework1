package com.example.tracktime.core.methodexecutionlog.model;

import com.example.tracktime.core.methodexecutionlog.entity.ExecutionType;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MethodExecutionLogCreateParam {

    @NotNull
    private ExecutionType type;
    @NotNull
    private String clazzName;
    @NotNull
    private String methodName;
    @Builder.Default
    private boolean successful = true;
    @NotNull
    @Builder.Default
    private Long executionTime = 0L;

}
