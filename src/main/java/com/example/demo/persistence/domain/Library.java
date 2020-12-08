package com.example.demo.persistence.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String name;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Book> books;

    public Library(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Library(String name) {
        super();
        this.name = name;
    }

}
