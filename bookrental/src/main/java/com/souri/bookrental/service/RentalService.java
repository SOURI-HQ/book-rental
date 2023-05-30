package com.souri.bookrental.service;

import com.souri.bookrental.domain.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book getBook(Integer id) {
        String url = "http://localhost:8080/bookservice/book/" + id;
        ResponseEntity<Book> responseBook = restTemplate.exchange(url, HttpMethod.GET, null, Book.class);

        return responseBook.getBody();
    }

    public Book borrowBook(Integer id) {
        String url = "http://localhost:8080/bookservice/book/unavailable/" + id;
        ResponseEntity<Book> responseBook = restTemplate.exchange(url, HttpMethod.GET, null, Book.class);

        return responseBook.getBody();
    }

    public Book returnBook(Integer id) {
        String url = "http://localhost:8080/bookservice/book/available/" + id;
        ResponseEntity<Book> responseBook = restTemplate.exchange(url, HttpMethod.GET, null, Book.class);

        return responseBook.getBody();
    }
}
