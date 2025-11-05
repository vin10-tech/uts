package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRequest;

@Service
public class BookService {

    // private final static int LENGTH = 5; // -> Konstanta ini tidak diperlukan lagi
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public Book addBook(BookRequest request) {
        Book savedBooks = new Book();

        // PERBAIKAN 1: Tetap gunakan camelCase
        savedBooks.setId(generateId()); // Ini sekarang mengembalikan Integer
        savedBooks.setTitle(request.getTitle());
        savedBooks.setAuthor(request.getAuthor());
        savedBooks.setPrice(request.getPrice());

        books.add(savedBooks);
        return savedBooks;
    }

    // PERBAIKAN 2: Ubah nama method ke camelCase
    // PERBAIKAN 3: Logika disederhanakan untuk mengembalikan Integer
    private Integer generateId() {
        // Cukup kembalikan ukuran list + 1
        return books.size() + 1;
    }
}