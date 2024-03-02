package ru.hse.project.snow.white.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hse.project.snow.white.api.dto.Book;
import ru.hse.project.snow.white.data.repositories.BookRepository;
import ru.hse.project.snow.white.mappers.BookDataModelToBookDtoMapper;
import ru.hse.project.snow.white.mappers.BookDtoToBookDataModeMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BooksServiceImpl implements BooksService {

    private final BookDataModelToBookDtoMapper bookDataModelToBookDtoMapper;

    private final BookDtoToBookDataModeMapper bookDtoToBookDataModeMapper;

    private final BookRepository bookRepository;

    @Override
    public Book findBook(UUID id) {
        Optional<ru.hse.project.snow.white.data.Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            ru.hse.project.snow.white.data.Book book = optionalBook.get();

            return bookDataModelToBookDtoMapper.map(book);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id=" + id + " was not found");
    }

    @Override
    public List<Book> listBooks() {
        List<ru.hse.project.snow.white.data.Book> books = bookRepository.findAll();

        return books.stream()
                .map(bookDataModelToBookDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Book saveNewBook(Book book) {
        return bookDataModelToBookDtoMapper.map(bookRepository.save(bookDtoToBookDataModeMapper.map(book)));
    }
}
