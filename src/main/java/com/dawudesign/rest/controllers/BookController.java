package com.dawudesign.rest.controllers;

import com.dawudesign.rest.entities.Book;
import com.dawudesign.rest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository repository;

    @GetMapping("/book")
    public List<Book> index ()
    {
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book show(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/book")
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/book/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        Book bookUpdate = repository.findById(id).get();
        bookUpdate.setTitle(book.getTitle());
        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate.setDescription(book.getDescription());
        return repository.save(bookUpdate);
    }

    @DeleteMapping("/book/{id}")
    public boolean delete(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }
}
