package com.example.tracktime.core.methodexecutionlog.web.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Schema(description = "Статистика по общему времени выполнения методов по классам")
@Accessors(chain = true)
public class TotalClazzMethodsExecutionTimeStatisticDto {

    @Schema(description = "Общее время выполнения методов по классам")
    private List<TotalClazzMethodsExecutionTimeDto> totalClazzMethodsExecutionTime;

    //для дальнейшего расширения
}
