package com.example.tracktime.core.tracktime.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
    private final ThreadPoolTaskExecutor applicationTaskExecutor;

    @Pointcut("@annotation(com.example.tracktime.core.tracktime.annotation.TrackTime)")
    public void trackTime() {
    }

    @Pointcut("@annotation(com.example.tracktime.core.tracktime.annotation.TrackAsyncTime)")
    public void trackAsyncTime() {
    }

    @Around(value = "trackTime()")
    public Object trackSyncTime(ProceedingJoinPoint joinPoint) {
        return trackTime(joinPoint, ExecutionType.SYNC);
    }

    /**
     * Оценка времени выполнение метода происходит асинхронно. Вызывающий код
     * не получит результат работы целевого метода (всегда null).
     * Это поведение схоже с реализацией @Async.
     *
     * @param joinPoint точка соединения
     * @return null
     */
    @Around(value = "trackAsyncTime()")
    public Object trackAsyncTime(ProceedingJoinPoint joinPoint) {
        applicationTaskExecutor.execute(() -> trackTime(joinPoint, ExecutionType.ASYNC));
        return null;
    }

    private Object trackTime(ProceedingJoinPoint joinPoint, ExecutionType type) {

        Object joinPointResult;

        var start = System.currentTimeMillis();
        try {
            joinPointResult = joinPoint.proceed();
        } catch (Throwable th) {
            methodExecutionLogService.create(createUnSuccessfulParam(joinPoint, type));
            throw new RuntimeException(th);
        }
        var executionTime = System.currentTimeMillis() - start;

        methodExecutionLogService.create(createSuccessfulParam(joinPoint, executionTime, type));

        return joinPointResult;
    }

    private MethodExecutionLogCreateParam createUnSuccessfulParam(ProceedingJoinPoint joinPoint,
            ExecutionType type) {

        return createParam(joinPoint, false, 0L, type);
    }

    private MethodExecutionLogCreateParam createSuccessfulParam(ProceedingJoinPoint joinPoint,
            Long executionTime,
            ExecutionType type) {

        return createParam(joinPoint, true, executionTime, type);
    }

    private MethodExecutionLogCreateParam createParam(ProceedingJoinPoint joinPoint,
            boolean successful,
            Long executionTime,
            ExecutionType type) {

        return MethodExecutionLogCreateParam.builder()
                .type(type)
                .clazzName(joinPoint.getSignature().getDeclaringType().getName())
                .methodName(joinPoint.getSignature().getName())
                .successful(successful)
                .executionTime(executionTime)
                .build();
    }

}
