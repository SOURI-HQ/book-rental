package com.souri.bookrental.domain;

public class Book {

    private Integer id;
    private String title;
    private String author;
    private Genre genre;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void makeAvailable() {
        isAvailable = true;
    }

    public void makeUnavailable() {
        isAvailable = false;
    }
}
