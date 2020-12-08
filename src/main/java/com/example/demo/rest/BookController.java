package com.example.demo.rest;

import com.example.demo.dto.BookDto;
import com.example.demo.persistence.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> create(@RequestBody Book book) {
        BookDto created = this.service.create(book);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<BookDto>> read() {
        return ResponseEntity.ok(this.service.readAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BookDto> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readOne(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(this.service.update(bookDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDto> delete(@PathVariable Long id) {
        return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("findByTitle/{title}")
    public ResponseEntity<List<BookDto>> findByName(@PathVariable String title) {
        return ResponseEntity.ok(this.service.findByTitle(title));
    }

    @GetMapping("findByAuthor/{author}")
    public ResponseEntity<List<BookDto>> findByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(this.service.findByAuthor(author));
    }
}
