package ru.hse.project.snow.white.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hse.project.snow.white.data.repositories.BookRepository;
import ru.hse.project.snow.white.dto.Book;
import ru.hse.project.snow.white.mappers.BookDataModelToBookDtoMapper;
import ru.hse.project.snow.white.mappers.BookDtoToBookDataModeMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookDataModelToBookDtoMapper bookDataModelToBookDtoMapper;

    private final BookDtoToBookDataModeMapper bookDtoToBookDataModeMapper;

    private final BookRepository bookRepository;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") UUID id) {
        Optional<ru.hse.project.snow.white.data.Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            ru.hse.project.snow.white.data.Book book = optionalBook.get();

            return bookDataModelToBookDtoMapper.map(book);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id=" + id + " was not found");
    }

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        List<ru.hse.project.snow.white.data.Book> books = bookRepository.findAll();

        return books.stream()
                .map(bookDataModelToBookDtoMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookDataModelToBookDtoMapper.map(bookRepository.save(bookDtoToBookDataModeMapper.map(book)));
    }
}
