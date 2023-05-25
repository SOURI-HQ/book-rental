package com.souri.bookservice.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(columnDefinition = "BIT default false")
    private Boolean isAvailable;

    public Book() {
    }

    public Book(Integer id, String title, String author, Genre genre, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

}
