package com.example.tracktime.core.methodexecutionlog.web.dto;

import com.example.tracktime.core.methodexecutionlog.entity.ExecutionType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Кол-во по типу")
public class CountByExecutionTypeDto {
    @Schema(description = "Тип")
    private ExecutionType executionType;
    @Schema(description = "Кол-во")
    private Long count;
}
