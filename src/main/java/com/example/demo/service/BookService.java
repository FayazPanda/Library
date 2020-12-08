package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.persistence.domain.Book;
import com.example.demo.persistence.repo.BookRepo;
import com.example.demo.util.SpringBeanUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepo repo;

    private ModelMapper mapper;


    private BookDto mapToDTO(Book book) {
        return this.mapper.map(book, BookDto.class);
    }

    @Autowired
    public BookService(BookRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    public BookDto create(Book book) {
        return this.mapToDTO(this.repo.save(book));
    }

    public List<BookDto> readAll() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public BookDto readOne(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow());
    }

    public BookDto update(BookDto bookDto, Long id) {
        Book toUpdate = this.repo.findById(id).orElseThrow();
        toUpdate.setTitle(bookDto.getTitle());
        SpringBeanUtil.mergeNotNull(bookDto, toUpdate);
        return this.mapToDTO(this.repo.save(toUpdate));

    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

    public List<BookDto> findByTitle(String title) {
        return this.repo.findByTitle(title).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<BookDto> findByAuthor(String author) {
        return this.repo.findByAuthor(author).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
