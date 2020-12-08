package com.example.demo.persistence.repo;

import com.example.demo.persistence.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM BOOK WHERE TITLE =?1", nativeQuery = true)
    List<Book> findByTitle(String title);

    @Query(value = "SELECT * FROM BOOK WHERE AUTHOR =?1", nativeQuery = true)
    List<Book> findByAuthor(String author);


}
