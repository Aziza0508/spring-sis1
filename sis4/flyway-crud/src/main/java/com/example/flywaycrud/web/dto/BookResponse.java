package com.example.flywaycrud.web.dto;

import com.example.flywaycrud.domain.Book;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Integer publishedYear;
    private String isbn;

    public static BookResponse from(Book b) {
        BookResponse r = new BookResponse();
        r.id = b.getId();
        r.title = b.getTitle();
        r.author = b.getAuthor();
        r.publishedYear = b.getPublishedYear();
        r.isbn = b.getIsbn();
        return r;
    }

    // getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Integer getPublishedYear() { return publishedYear; }
    public String getIsbn() { return isbn; }
}