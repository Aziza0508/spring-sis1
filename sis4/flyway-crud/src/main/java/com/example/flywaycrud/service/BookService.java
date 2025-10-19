package com.example.flywaycrud.service;

import com.example.flywaycrud.domain.Book;
import com.example.flywaycrud.repo.BookRepository;
import com.example.flywaycrud.web.dto.BookRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> list() {
        return repo.findAll();
    }

    public Book get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + id));
    }

    public Book create(BookRequest req) {
        Book b = new Book();
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setPublishedYear(req.getPublishedYear());
        b.setIsbn(req.getIsbn());
        return repo.save(b);
    }

    public Book update(Long id, BookRequest req) {
        Book b = get(id);
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setPublishedYear(req.getPublishedYear());
        b.setIsbn(req.getIsbn());
        return repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}