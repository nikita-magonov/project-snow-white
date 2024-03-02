package ru.hse.project.snow.white.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hse.project.snow.white.data.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
