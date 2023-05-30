package com.souri.bookrental.controller;

import com.souri.bookrental.domain.Book;
import com.souri.bookrental.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentalservice")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getBook(id));
    }

    @PutMapping("/book/unavailable/{id}")
    public ResponseEntity<Book> borrowBook(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.borrowBook(id));
    }

    @PutMapping("/book/available/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.returnBook(id));
    }
}
