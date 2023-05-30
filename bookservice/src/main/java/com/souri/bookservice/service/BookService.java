package com.souri.bookservice.service;

import com.souri.bookservice.exception.BookNotFoundException;
import com.souri.bookservice.exception.UnprocessableEntityException;
import com.souri.bookservice.domain.Book;
import com.souri.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Book addBook(Book book) {
        if (book.getId() != null) {
            throw new UnprocessableEntityException("Given entity cannot be processed: illegal name-value pair given [id]");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
        }
        else {
            throw new BookNotFoundException();
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else {
            throw new BookNotFoundException();
        }
    }

    public Book makeAvailable(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        //TODO: Check if book availability status is ok
        book.makeAvailable();

        return bookRepository.save(book);
    }

    public Book makeUnavailable(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.makeUnavailable();

        return bookRepository.save(book);
    }
}
