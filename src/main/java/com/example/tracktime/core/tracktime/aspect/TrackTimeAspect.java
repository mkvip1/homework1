package com.example.tracktime.core.tracktime.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.tracktime.core.methodexecutionlog.entity.ExecutionType;
import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;
import com.example.tracktime.core.methodexecutionlog.service.MethodExecutionLogService;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final MethodExecutionLogService methodExecutionLogService;

    @Pointcut("@annotation(com.example.tracktime.core.tracktime.annotation.TrackTime)")
    public void trackTime() {}

    @Around(value = "trackTime()")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {

        Object joinPointResult;

        var start = System.currentTimeMillis();
        try {
            joinPointResult = joinPoint.proceed();
        } catch (Throwable th) {
            methodExecutionLogService.create(createUnSuccessfulParam(joinPoint));
            throw th;
        }
        var executionTime = System.currentTimeMillis() - start;

        methodExecutionLogService.create(createSuccessfulParam(joinPoint, executionTime));

        return joinPointResult;
    }

    private MethodExecutionLogCreateParam createUnSuccessfulParam(ProceedingJoinPoint joinPoint) {
        return createParam(joinPoint, false, 0L);
    }

    private MethodExecutionLogCreateParam createSuccessfulParam(ProceedingJoinPoint joinPoint,
            Long executionTime) {
        return createParam(joinPoint, true, executionTime);
    }

    private MethodExecutionLogCreateParam createParam(ProceedingJoinPoint joinPoint,
            boolean successful,
            Long executionTime) {
        return MethodExecutionLogCreateParam.builder()
                .type(ExecutionType.SYNC)
                .clazzName(joinPoint.getSignature().getDeclaringType().getName())
                .methodName(joinPoint.getSignature().getName())
                .successful(successful)
                .executionTime(executionTime)
                .build();
    }

}
