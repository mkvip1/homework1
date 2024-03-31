package com.example.tracktime.core.methodexecutionlog.web.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Schema(description = "Статистика кол-ва по типам")
@Accessors(chain = true)
public class CountByExecutionTypeStatisticDto {

    @Schema(description = "Кол-во по типам")
    private List<CountByExecutionTypeDto> countByExecutionType;

    //для дальнейшего расширения
}
