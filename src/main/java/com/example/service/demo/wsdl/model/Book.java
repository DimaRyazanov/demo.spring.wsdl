package com.example.service.demo.wsdl.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "price", nullable = false)
    @Min(0)
    private double price;

    public Book() {
    }

    public Book(@NotBlank String name, @NotBlank String title, @Min(0) double price) {
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public Book(int id, @NotBlank String name, @NotBlank String title, @Min(0) double price) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
