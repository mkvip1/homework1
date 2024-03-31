package com.example.tracktime.core.methodexecutionlog.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Среднее время выполнения метода")
public class AverageMethodExecutionTimeDto {
    @Schema(description = "Имя класса")
    private String clazzName;
    @Schema(description = "Имя метода")
    private String methodName;
    @Schema(description = "Среднее время выполнения")
    private Long averageExecutionTime;
}
