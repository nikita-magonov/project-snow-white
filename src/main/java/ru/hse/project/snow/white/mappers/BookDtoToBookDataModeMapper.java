package ru.hse.project.snow.white.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDtoToBookDataModeMapper {

    @Mapping(source = "name", target = "title")
    @Mapping(source = "summary", target = "description")
    ru.hse.project.snow.white.data.Book map(ru.hse.project.snow.white.dto.Book bookDto);
}
