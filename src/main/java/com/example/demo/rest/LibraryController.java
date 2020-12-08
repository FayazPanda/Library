package com.example.demo.rest;

import com.example.demo.dto.LibraryDto;
import com.example.demo.persistence.domain.Library;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService service;

    @Autowired
    public LibraryController(LibraryService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<LibraryDto> create(@RequestBody Library library) {
        LibraryDto created = this.service.create(library);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<LibraryDto>> read() {
        return ResponseEntity.ok(this.service.readAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<LibraryDto> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readOne(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LibraryDto> update(@PathVariable Long id, @RequestBody LibraryDto libraryDto) {
        return new ResponseEntity<>(this.service.update(libraryDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LibraryDto> delete(@PathVariable Long id) {
        return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
