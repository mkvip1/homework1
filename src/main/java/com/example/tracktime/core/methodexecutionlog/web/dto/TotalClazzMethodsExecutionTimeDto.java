package com.example.tracktime.core.methodexecutionlog.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Общее время выполнения методов для класса")
public class TotalClazzMethodsExecutionTimeDto {
    @Schema(description = "Имя класса")
    private String clazzName;
    @Schema(description = "Общее время выполнения методов")
    private Long totalExecutionTime;
}
