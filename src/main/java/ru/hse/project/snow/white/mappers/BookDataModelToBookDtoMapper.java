package ru.hse.project.snow.white.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.hse.project.snow.white.dto.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDataModelToBookDtoMapper {

    @Mapping(source = "title", target = "name")
    @Mapping(source = "description", target = "summary")
    Book map(ru.hse.project.snow.white.data.Book bookDbModel);
}
