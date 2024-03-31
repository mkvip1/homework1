package com.example.tracktime.core.methodexecutionlog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.tracktime.core.methodexecutionlog.entity.MethodExecutionLogEntity;
import com.example.tracktime.core.methodexecutionlog.model.MethodExecutionLogCreateParam;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.ERROR)
public interface MethodExecutionLogMapper {

    MethodExecutionLogMapper INSTANCE = Mappers.getMapper(MethodExecutionLogMapper.class);

    @Mapping(target = "id", ignore = true)
    MethodExecutionLogEntity toEntity(MethodExecutionLogCreateParam param);

}
