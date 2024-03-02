package ru.hse.project.snow.white.services;

import ru.hse.project.snow.white.api.dto.Book;

import java.util.List;
import java.util.UUID;

public interface BooksService {
    Book findBook(UUID id);

    List<Book> listBooks();

    Book saveNewBook(Book book);
}
