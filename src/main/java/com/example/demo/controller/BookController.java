package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRequest;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService studentService;

    public BookController(BookService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return studentService.getBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody BookRequest studentRequest) {
        return studentService.addBook(studentRequest);
    }
}