package com.souri.bookservice.service;

import com.souri.bookservice.model.Book;
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
        return bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }

    public Book makeAvailable(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.makeAvailable();
        }
        return bookRepository.save(book);
    }

    public Book makeUnavailable(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.makeUnavailable();
        }
        return bookRepository.save(book);
    }

}
