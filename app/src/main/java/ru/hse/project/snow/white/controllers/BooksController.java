package ru.hse.project.snow.white.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hse.project.snow.white.api.BooksApi;
import ru.hse.project.snow.white.api.dto.Book;
import ru.hse.project.snow.white.services.BooksService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/books")
public class BooksController implements BooksApi {

    private final BooksService booksService;

    @Override
    @GetMapping(path = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") UUID id) {
        return booksService.findBook(id);
    }

    @Override
    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return booksService.listBooks();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return booksService.saveNewBook(book);
    }
}
