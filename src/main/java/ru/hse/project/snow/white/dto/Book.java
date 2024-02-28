package ru.hse.project.snow.white.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public class Book {

    private UUID id;

    private String name;

    private String summary;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
