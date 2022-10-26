package com.f1.records.mappers;

import com.f1.records.pojos.DAOs.StatusDAO;
import com.f1.records.pojos.DTOs.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversalMapper {
    UniversalMapper INSTANCE = Mappers.getMapper(UniversalMapper.class);

    StatusDAO statusToDTO(StatusDTO statusDTO);

}
