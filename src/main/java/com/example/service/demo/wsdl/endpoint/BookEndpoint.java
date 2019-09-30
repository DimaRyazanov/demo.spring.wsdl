package com.example.service.demo.wsdl.endpoint;

import com.example.service.demo.wsdl.model.Book;
import com.example.service.demo.wsdl.service.BookService;
import com.example.service.demo.wsdl.util.CastUtil;
import example.com.services.books.AddBookRequest;
import example.com.services.books.AddBookResponse;
import example.com.services.books.GetBookByIdRequest;
import example.com.services.books.GetBookByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {
    private BookService service;

    public BookEndpoint(BookService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = "http://com.example/services/books", localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        Book requestBook = new Book();
        requestBook.setName(request.getName());
        requestBook.setTitle(request.getTitle());
        requestBook.setPrice(request.getPrice());
        Book result = service.create(requestBook);
        response.setBook(CastUtil.castToBookXSD(result));

        return response;
    }

    @PayloadRoot(namespace = "http://com.example/services/books", localPart = "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse getBookById(@RequestPayload GetBookByIdRequest request) {
        GetBookByIdResponse response = new GetBookByIdResponse();
        response.setBook(CastUtil.castToBookXSD(service.getById(request.getBookId())));

        return response;
    }
}
