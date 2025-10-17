package com.example.demo;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BooksController {

    private List<Books> books = new ArrayList<>();

    // POST: Save Book
    @PostMapping
    public String saveBook(@RequestBody Books book) {
        books.add(book);
        return "Book saved successfully!";
    }

    // GET: All Books
    @GetMapping
    public List<Books> getAllBooks() {
        return books;
    }

    // GET: Book by ID
    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Integer id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(new Books(0, "Not Found", "N/A", 0.0));
    }
}
