package com.example.service.demo.wsdl.service;

import com.example.service.demo.wsdl.model.Book;
import com.example.service.demo.wsdl.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book create(Book book) {
        return repository.save(book);
    }

    public Book getById(int id) {
        return repository.findById(id).orElse(null);
    }
}
