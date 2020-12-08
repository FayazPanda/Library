package com.example.demo.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @ManyToOne
    private Library library;

    public Book(Long id, String title, String author, String make, String model, int doors) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, String make, String model, int doors) {
        super();
        this.title = title;
        this.author = author;
    }

}
