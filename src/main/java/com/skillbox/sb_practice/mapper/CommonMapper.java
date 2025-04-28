package com.skillbox.sb_practice.mapper;

import com.skillbox.sb_practice.dto.CommonUpsertResponse;
import com.skillbox.sb_practice.entity.CommonMappedValues;
import org.mapstruct.Mapping;

public interface CommonMapper {
    @Mapping(target = "id", source = "id")
    CommonUpsertResponse mapToCommon(CommonMappedValues dto);
}
