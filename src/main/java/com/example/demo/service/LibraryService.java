package com.example.demo.service;

import com.example.demo.dto.LibraryDto;
import com.example.demo.persistence.domain.Library;
import com.example.demo.persistence.repo.LibraryRepo;
import com.example.demo.util.SpringBeanUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private LibraryRepo repo;

    private ModelMapper mapper;


    private LibraryDto mapToDTO(Library library) {
        return this.mapper.map(library, LibraryDto.class);
    }

    @Autowired
    public LibraryService(LibraryRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    public LibraryDto create(Library library) {
        return this.mapToDTO(this.repo.save(library));
    }

    public List<LibraryDto> readAll() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());

    }

    public LibraryDto readOne(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow());
    }

    public LibraryDto update(LibraryDto libraryDto, Long id) {
        Library toUpdate = this.repo.findById(id).orElseThrow();
        toUpdate.setName(libraryDto.getName());
        SpringBeanUtil.mergeNotNull(libraryDto, toUpdate);
        return this.mapToDTO(this.repo.save(toUpdate));

    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}
