package com.example.tracktime.core.methodexecutionlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tracktime.core.methodexecutionlog.entity.AverageMethodExecutionTimeInfoProjection;
import com.example.tracktime.core.methodexecutionlog.entity.CountByExecutionTypeProjection;
import com.example.tracktime.core.methodexecutionlog.entity.MethodExecutionLogEntity;
import com.example.tracktime.core.methodexecutionlog.entity.TotalClazzMethodsExecutionTimeProjection;

public interface MethodExecutionLogRepository extends JpaRepository<MethodExecutionLogEntity, Long> {

    @Query("""
                select l.type as executionType, count(*) as count from MethodExecutionLogEntity l
                group by l.type
            """)
    List<CountByExecutionTypeProjection> getCountByExecutionType();

    @Query("""
                select l.clazzName as clazzName,
                    l.methodName as methodName,
                    count(*) as count,
                    sum(l.executionTime) as totalExecutionTime from MethodExecutionLogEntity l
                where l.successful = true
                group by l.clazzName, l.methodName
            """)
    List<AverageMethodExecutionTimeInfoProjection> getAverageMethodExecutionTimeInfo();

    @Query("""
                select l.clazzName as clazzName, sum(l.executionTime) as totalExecutionTime from MethodExecutionLogEntity l
                where l.successful = true
                group by l.clazzName
            """)
    List<TotalClazzMethodsExecutionTimeProjection> getTotalClazzMethodsExecutionTime();

}