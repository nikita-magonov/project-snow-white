package ru.hse.project.snow.white.api;

import ru.hse.project.snow.white.api.dto.Book;

import java.util.List;
import java.util.UUID;

public interface BooksApi {

    Book getBook(UUID id);

    List<Book> getBooks();

    Book postBook(Book book);
}
