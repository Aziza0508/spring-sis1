package com.example.sis6.book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "CRUD endpoints for books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    @Operation(summary = "List all books")
    public List<Book> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by id")
    @ApiResponse(responseCode = "200", description = "Found the book",
            content = @Content(schema = @Schema(implementation = Book.class)))
    @ApiResponse(responseCode = "404", description = "Book not found")
    public ResponseEntity<Book> get(@Parameter(description = "Book id") @PathVariable long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new book")
    public Book create(@Valid @RequestBody Book book) {
        return repo.save(book);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing book")
    public ResponseEntity<Book> update(@PathVariable long id, @Valid @RequestBody Book book) {
        return repo.findById(id)
                .map(existing -> {
                    book.setId(id);
                    return ResponseEntity.ok(repo.save(book));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book by id")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean removed = repo.delete(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}