package com.example.service.demo.wsdl.util;

import com.example.service.demo.wsdl.model.Book;
import example.com.services.books.BookXSD;

public class CastUtil {
    public static BookXSD castToBookXSD(Book book) {
        BookXSD casted = new BookXSD();
        casted.setName(book.getName());
        casted.setBookId(book.getId());
        casted.setTitle(book.getTitle());
        casted.setPrice(book.getPrice());

        return casted;
    }

    public static Book castToBook(BookXSD bookXSD) {
        return new Book(bookXSD.getBookId(), bookXSD.getName(), bookXSD.getTitle(), bookXSD.getPrice());
    }
}
