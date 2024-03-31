package com.example.tracktime.core.methodexecutionlog.web.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Schema(description = "Статистика по среднему времени выполнения методов")
@Accessors(chain = true)
public class AverageMethodExecutionTimeStatisticDto {

    @Schema(description = "Среднее время выполнения методов")
    private List<AverageMethodExecutionTimeDto> averageMethodExecutionTime;

    //для дальнейшего расширения
}
