package ru.hse.project.snow.white.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Book {

    private UUID id;

    private String name;

    private String summary;
}
