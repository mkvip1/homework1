package com.example.tracktime.core.methodexecutionlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tracktime.core.methodexecutionlog.entity.MethodExecutionLogEntity;

public interface MethodExecutionLogRepository extends JpaRepository<MethodExecutionLogEntity, Long> {

}