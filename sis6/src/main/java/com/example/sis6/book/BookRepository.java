package com.example.sis6.book;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepository {
    private final Map<Long, Book> store = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong(0);

    public BookRepository() {
        // seed some demo data
        save(new Book(null, "Clean Code", "Robert C. Martin", 2008));
        save(new Book(null, "Effective Java", "Joshua Bloch", 2018));
    }

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Book> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(ids.incrementAndGet());
        }
        store.put(book.getId(), book);
        return book;
    }

    public boolean delete(long id) {
        return store.remove(id) != null;
    }
}