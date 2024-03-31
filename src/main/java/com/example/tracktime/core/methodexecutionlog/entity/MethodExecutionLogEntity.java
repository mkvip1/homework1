package com.example.tracktime.core.methodexecutionlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "method_execution_log")
public class MethodExecutionLogEntity {

    @Id
    @GeneratedValue(generator = "method_execution_log_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "method_execution_log_sequence", sequenceName = "method_execution_log_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ExecutionType type;

    @Column(name = "clazz_name", nullable = false)
    private String clazzName;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(name = "successful", nullable = false)
    private boolean successful = true;

    @Column(name = "execution_time", nullable = false)
    private Long executionTime;

}
