package com.example.tracktime.core.methodexecutionlog.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.tracktime.core.methodexecutionlog.entity.CountByExecutionTypeProjection;
import com.example.tracktime.core.methodexecutionlog.entity.MethodExecutionLogEntity;
import com.example.tracktime.core.methodexecutionlog.entity.TotalClazzMethodsExecutionTimeProjection;
import com.example.tracktime.core.methodexecutionlog.model.AverageMethodExecutionTime;
import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;
import com.example.tracktime.core.methodexecutionlog.web.dto.AverageMethodExecutionTimeDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.CountByExecutionTypeDto;
import com.example.tracktime.core.methodexecutionlog.web.dto.TotalClazzMethodsExecutionTimeDto;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.ERROR)
public interface MethodExecutionLogMapper {

    MethodExecutionLogMapper INSTANCE = Mappers.getMapper(MethodExecutionLogMapper.class);

    @Mapping(target = "id", ignore = true)
    MethodExecutionLogEntity toEntity(MethodExecutionLogCreateParam param);

    List<CountByExecutionTypeDto> toCountByExecutionTypeDtoList(List<CountByExecutionTypeProjection> list);

    List<AverageMethodExecutionTimeDto> toAverageMethodExecutionTimeDtoList(List<AverageMethodExecutionTime> models);

    List<TotalClazzMethodsExecutionTimeDto> toTotalClazzMethodsExecutionTimeDtoList(List<TotalClazzMethodsExecutionTimeProjection> proj);

}
