package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class LibraryDto {

    public Long id;
    public String name;

    private List<BookDto> books = new ArrayList<>();
}
